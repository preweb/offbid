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
import java.sql.*;
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

public class AdminViewFarmer extends HttpServlet {

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
            
            String farmerTable = "SELECT farmer.farmer_id,farmer.name,farmer.age,contact.email_id,"
                    + "contact.phone_no,farmer.aadhar,address.line1,address.line2,address.city,"
                    + "address.state,address.country,address.pincode FROM((farmer LEFT JOIN contact "
                    + "ON farmer.contact_id=contact.contact_id) LEFT JOIN address "
                    + "ON farmer.address_id=address.address_id) where farmer_id>0";
            //execute sql
            PreparedStatement stmt = con.prepareStatement(farmerTable);
            ResultSet rs = stmt.executeQuery();
            ArrayList farmerList = new ArrayList();
            while(rs.next()){
                System.out.println("Farmer table captured.");
                Farmer farmer = new Farmer();
                Address farmerAddress = new Address();
                Contact farmerContact = new Contact();
                farmer.setFarmerID(rs.getInt("farmer_id"));
                farmer.setName(rs.getString("name"));
                farmer.setAge(rs.getInt("age"));
                farmerContact.setEmailID(rs.getString("email_id"));
                farmerContact.setPhoneNo(rs.getLong("phone_no"));
                farmer.setAadhar(rs.getLong("aadhar"));
                farmerAddress.setLine1(rs.getString("line1"));
                farmerAddress.setLine2(rs.getString("line2"));
                farmerAddress.setCity(rs.getString("city"));
                farmerAddress.setState(rs.getString("state"));
                farmerAddress.setCountry(rs.getString("country"));
                farmerAddress.setPincode(rs.getInt("pincode"));
                //Adding data to arrayList
                farmerList.add(farmer);
                farmerList.add(farmerContact);
                farmerList.add(farmerAddress);
                }
                request.setAttribute("farmers",farmerList);
                RequestDispatcher rd = request.getRequestDispatcher("AdminViewFarmer.jsp");
                rd.forward(request, response);
            } 
        catch (SQLException ex) {
               System.out.println(ex); 
            }
        }
    
// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     *
     * Handles the HTTP <code>GET</code> method.
     *
     *
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     *
     */
    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     *
     * Handles the HTTP <code>POST</code> method.
     *
     *
     *
     * @param request servlet request
     *
     * @param response servlet response
     *
     * @throws ServletException if a servlet-specific error occurs
     *
     * @throws IOException if an I/O error occurs
     *
     */
    @Override

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     *
     * Returns a short description of the servlet.
     *
     *
     *
     * @return a String containing servlet description
     *
     */
    @Override

    public String getServletInfo() {

        return "Short description";

    }// </editor-fold>
}
