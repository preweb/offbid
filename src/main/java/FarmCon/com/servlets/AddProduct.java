/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.connection.ConnectionManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ANIRBAN
 */
public class AddProduct extends HttpServlet {

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
            String productName = request.getParameter("pname");
            String productDetails = request.getParameter("pdesc");
            double unitPrice = Double.parseDouble(request.getParameter("punit"));
            int maxQuantity =Integer.parseInt(request.getParameter("pquant"));
            int farmerId=1;
            int maxProductId;InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
            Connection con=ConnectionManager.getConnection(inputFile);
           System.out.println("Connection established::"+con);
            String getMaxProductId="select max(product_id) from product";
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery(getMaxProductId);
            rs1.next();
            maxProductId = rs1.getInt(1);
           String sql = "INSERT INTO product(product_id, name,description,unit_price,max_quantity,farmer_id) VALUES (?, ?, ?, ?, ?, ?)";
           PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, (maxProductId+1));
            stmt.setString(2, productName);
            stmt.setString(3, productDetails);
            stmt.setDouble(4, unitPrice);
            stmt.setInt(5, maxQuantity);
            stmt.setInt(6, farmerId);
            System.out.println("Sql to execute="+stmt);
            // execute SQL
            int rs = stmt.executeUpdate();
             if(rs==1)
            {
                //user present
                out.println("Added Successfully......");
                
                RequestDispatcher rd=request.getRequestDispatcher("FarmerHomePage.jsp");
                rd.forward(request, response);
            }
            else
            {
                //failed validation
                out.println("Adding is Not Successful...........");
            }
         
        } catch (SQLException e)
        {
            System.out.println(e);
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
