/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.beans.*;
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
 * @author Sourav
 */
public class AdminViewCustomer extends HttpServlet {

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
        String customerTable = "SELECT customer.customer_id,customer.name,customer.age,"
                + "customer.aadhar,contact.email_id,contact.phone_no,address.line1,"
                + "address.line2,address.city,address.state,address.country,address.pincode"
                + " FROM ((customer LEFT JOIN contact ON customer.contact_id=contact.contact_id)"
                + " LEFT JOIN address ON customer.address_id=address.address_id) where customer_id>0";
            PreparedStatement stmt = con.prepareStatement(customerTable);
            ResultSet rs = stmt.executeQuery();
            ArrayList customerList = new ArrayList();
            while(rs.next()){
                System.out.println("Customer Table captured.");
                Customer customer = new Customer();
                Contact customerContact = new Contact();
                Address customerAddress = new Address();
                customer.setCustomerID(rs.getInt("customer_id"));
                customer.setName(rs.getString("name"));
                customer.setAge(rs.getInt("age"));
                customerContact.setEmailID(rs.getString("email_id"));
                customerContact.setPhoneNo(rs.getLong("phone_no"));
                customer.setAadhar(rs.getLong("aadhar"));
                customerAddress.setLine1(rs.getString("line1"));
                customerAddress.setLine2(rs.getString("line2"));
                customerAddress.setCity(rs.getString("city"));
                customerAddress.setState(rs.getString("state"));
                customerAddress.setCountry(rs.getString("country"));
                customerAddress.setPincode(rs.getInt("pincode"));
                //Adding data to ArrayList
                customerList.add(customer);
                customerList.add(customerContact);
                customerList.add(customerAddress);
            }
            request.setAttribute("customers", customerList);
            RequestDispatcher rd = request.getRequestDispatcher("AdminViewCustomer.jsp");
            rd.forward(request, response);
        } 
         catch (SQLException ex)
         {
             System.out.println(ex);
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
