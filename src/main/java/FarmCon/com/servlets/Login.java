/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;
import FarmCon.com.beans.Customer;
import FarmCon.com.beans.Farmer;
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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author HP
 */
public class Login extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String emailAddress = request.getParameter("emailAddress");
            String password = request.getParameter("password");
            String tableName = request.getParameter("user");
            InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
            Connection con=ConnectionManager.getConnection(inputFile);
            System.out.println("Connection established::"+con);
//Write SQL 

            if ("customer".equals(tableName)) {
                String sql = "SELECT customer.name,contact.email_id, customer.password,customer.customer_id from auction.contact,auction.customer where contact.contact_id=customer.contact_id and email_id=? and password=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, emailAddress);
            stmt.setString(2, password);
            
            System.out.println("Sql to execute="+stmt);
            // execute SQL
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                
            
            System.out.println("Login Successful...........");

                HttpSession session = request.getSession();
                Customer customer = new Customer();
                customer.setCustomerID(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                session.setAttribute("customer", customer);
               

                RequestDispatcher rd = request.getRequestDispatcher("CustomerHomePage.jsp");
                rd.forward(request, response);
            }
            }
            else{
               out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect');");
                out.println("location='Login.jsp';");
                out.println("</script>");
            }

            if ("farmer".equals(tableName)) {
                String sql = "SELECT farmer.name,contact.email_id, farmer.password,farmer.farmer_id from auction.contact,auction.farmer where contact.contact_id=farmer.contact_id and email_id=? and password=? ";
            PreparedStatement stmt = con.prepareStatement(sql);
            
            stmt.setString(1, emailAddress);
            stmt.setString(2, password);
            
            System.out.println("Sql to execute="+stmt);
            // execute SQL
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                
            
            System.out.println("Login Successful...........");

                HttpSession session = request.getSession();
                Farmer farmer = new Farmer();
                farmer.setFarmerID(rs.getInt("farmer_id"));
                farmer.setName(rs.getString("name"));
                session.setAttribute("farmer", farmer);

                RequestDispatcher rd = request.getRequestDispatcher("FarmerHomePage.jsp");
                rd.forward(request, response);
            }
            }
            else{
               out.println("<script type=\"text/javascript\">");
                out.println("alert('User or password incorrect');");
                out.println("location='Login.jsp';");
                out.println("</script>");
            }
        }
        catch (SQLException ex) {
                System.out.println(ex.getMessage());
            
            
            
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet Login</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet Login at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
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
