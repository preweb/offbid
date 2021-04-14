/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.beans.Product;
import FarmCon.com.connection.ConnectionManager;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author kunal
 */
public class FarmerDisplayProducts extends HttpServlet {

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
           String sql = "SELECT * FROM product WHERE farmer_id = 1";
            InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
            Connection con=ConnectionManager.getConnection(inputFile);
            PreparedStatement stmt = con.prepareStatement(sql);
            System.out.println("Connection Created");
            ResultSet rs = stmt.executeQuery();
            System.out.println("Query executed");
            HttpSession session = request.getSession();
            System.out.println("Session Made");
            ArrayList<Product> arraylist = new ArrayList();
            
            while(rs.next())
            {
                Product product = new Product();
                product.setProductID(rs.getInt("product_id"));
                System.out.println(product.getProductID());
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("description"));
                product.setUnitPrice(rs.getDouble("unit_price"));
                product.setMaxQuantity(rs.getInt("max_quantity"));
                arraylist.add(product);
            }
            session.setAttribute("arraylist", arraylist);
            
            RequestDispatcher rd = request.getRequestDispatcher("FarmerProducts.jsp");
            rd.forward(request, response);
            
        } catch (SQLException ex) {
            ex.printStackTrace();
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
