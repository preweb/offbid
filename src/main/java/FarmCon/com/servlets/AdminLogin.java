/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.beans.Administrator;
import FarmCon.com.connection.ConnectionManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
@WebServlet(name = "AdminLogin", urlPatterns = {"/AdminLogin"})
public class AdminLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    
            String emailAddress = request.getParameter("email_address");
            String password = request.getParameter("password");
            InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
            Connection con=ConnectionManager.getConnection(inputFile);

            System.out.println("Connection established::" + con);
//Write SQL 
            String sql = "SELECT * FROM administrator where email_address=? and password=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, emailAddress);
            stmt.setString(2, password);
            System.out.println("Sql to execute=" + stmt);
            // execute SQL
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                //user present
                System.out.println("Login Successful...........");

                HttpSession session = request.getSession();
                Administrator admin = new Administrator();
                admin.setAdminID(rs.getInt("admin_id"));
                admin.setName(rs.getString("name"));
                admin.setEmailAddress(rs.getString("email_address"));
                admin.setPassword(rs.getString("password"));
                session.setAttribute("admin", admin);

                RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
                rd.forward(request, response);
            } else {
                //failed validation
                System.out.println("Login Not Successful...........");
//                out.println("<script>alert('Invalid Email/Password!');</script>");
//                HttpSession session = request.getSession();
//                Flag flag = new Flag();
//                flag.setFlag(1);
//                session.setAttribute("flag", flag);
//                RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
//                rd.forward(request, response);
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('User or password incorrect');");
                    out.println("location='AdminLogin.jsp';");
                    out.println("</script>");
//                RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.jsp");
//                rd.forward(request, response);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }


// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
