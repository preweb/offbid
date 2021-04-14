    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.beans.Invoice;
import FarmCon.com.connection.ConnectionManager;
import java.io.IOException;
import java.io.InputStream;
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

/**
 *
 * @author Sweety
 */
public class AdminViewInvoice extends HttpServlet {

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
       try {
        InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
        Connection con=ConnectionManager.getConnection(inputFile);
        System.out.println("Connection established::" + con);
        String invoiceTable = "select * from invoice where invoice_id>0";
            PreparedStatement stmt = con.prepareStatement(invoiceTable);
            ResultSet rs = stmt.executeQuery();
            ArrayList invoiceList = new ArrayList();
            while(rs.next()){
                System.out.println("invoice.");
                Invoice invoice = new Invoice();
               invoice.setInvoiceID(rs.getInt("invoice_id"));
               invoice.setProductID(rs.getInt("product_id"));
               invoice.setProductName(rs.getString("product_name"));
               invoice.setAuctionID(rs.getInt("auction_id"));
               invoice.setProductDescription(rs.getString("product_description"));
               invoice.setCustomerID(rs.getInt("customer_id"));
               invoice.setCustomerName(rs.getString("customer_name"));
               invoice.setTotalAmount(rs.getDouble("total_amount"));
               invoice.setCustomerAddress(rs.getString("customer_address"));
               invoice.setCustomerEmail(rs.getString("customer_email"));
               invoice.setCustomerPhone(rs.getLong("customer_phone"));
               invoice.setFarmerName(rs.getString("farmer_name"));
               invoice.setFarmerID(rs.getInt("farmer_id"));
               invoice.setRequiredQuantity(rs.getInt("required_quantity"));
               invoice.setFarmerAddress(rs.getString("farmer_address"));
               invoice.setFarmerEmail(rs.getString("farmer_email"));
               invoice.setFarmerPhone(rs.getLong("farmer_phone"));               
               
               
                //Adding data to ArrayList
                invoiceList.add(invoice);
            }
            request.setAttribute("invoice", invoiceList);
            RequestDispatcher rd = request.getRequestDispatcher("AdminViewInvoice.jsp");
            rd.forward(request, response);
        } 
         catch (SQLException ex) { System.out.println(ex); }
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
    
 