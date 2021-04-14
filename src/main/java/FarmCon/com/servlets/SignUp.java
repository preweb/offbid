/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;
import FarmCon.com.connection.ConnectionManager;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author HP
 */
public class SignUp extends HttpServlet {

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
            
            String tableName = request.getParameter("user");
            String name = request.getParameter("name");
            int age = Integer.parseInt(request.getParameter("age"));
            long aadhar = Long.parseLong(request.getParameter("aadhar"));

            String line1 = request.getParameter("line1");
            String line2 = request.getParameter("line2");
            String city = request.getParameter("city");
            String state = request.getParameter("state");
            String country = request.getParameter("country");
            int pincode = Integer.parseInt(request.getParameter("pincode"));

            long phoneNo = Long.parseLong(request.getParameter("phone_no"));
           
            String emailAddress = request.getParameter("emailAddress");
            String password = request.getParameter("password");
            String confirmPassword = request.getParameter("confirmPassword");
           
            boolean result=false;
           
            String getMaxAddressId = "SELECT max(address_id) from address";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getMaxAddressId);
            rs.next();
            int maxAddressId = rs.getInt(1);

//Write SQL 
            String address_sql = "INSERT INTO address(address_id,line1,line2,city,state,country,pin_code) values(?,?,?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(address_sql);

            stmt.setInt(1, (maxAddressId + 1));
            stmt.setString(2, line1);
            stmt.setString(3, line2);
            stmt.setString(4, city);
            stmt.setString(5, state);
            stmt.setString(6, country);
            stmt.setInt(7, pincode);

            stmt.executeUpdate();

            String getMaxContactId = "SELECT max(contact_id) from contact";
            st = con.createStatement();
            rs = st.executeQuery(getMaxContactId);
            rs.next();
            int maxContactId = rs.getInt(1);

            String contact_sql = "INSERT INTO contact(contact_id,email_id,phone_no) values(?,?,?)";
            stmt = con.prepareStatement(contact_sql);
            stmt.setInt(1, (maxContactId + 1));
            stmt.setString(2, emailAddress);
            stmt.setLong(3, phoneNo);
            stmt.executeUpdate();
            
            int maxId;
            if ("customer".equals(tableName)) {
                String getMaxCustomerId = "SELECT max(customer_id) from customer";
                st = con.createStatement();
                rs = st.executeQuery(getMaxCustomerId);
                rs.next();
                maxId = rs.getInt(1);
            } else {
                String getMaxFarmerId = "SELECT max(farmer_id) from farmer";
                st = con.createStatement();
                rs = st.executeQuery(getMaxFarmerId);
                rs.next();
                maxId = rs.getInt(1);
            }

            if ("customer".equals(tableName)) {
                String sql = "INSERT INTO customer(customer_id,name,age,aadhar,address_id,contact_id,password) values(?,?,?,?,?,?,?)";

            stmt = con.prepareStatement(sql);
            

            stmt.setInt(1, (maxId + 1));
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setLong(4, aadhar);
            stmt.setInt(5,maxAddressId+1);
            stmt.setInt(6,maxContactId+1);
            stmt.setString(7, password);
            //stmt.setString(7, confirmPassword);
            System.out.println("Sql to execute=" + stmt);
            // execute SQL
            int i = stmt.executeUpdate();
                

            }

            if ("farmer".equals(tableName)) {
                String sql = "INSERT INTO farmer(farmer_id,name,age,aadhar,address_id,contact_id,password) values(?,?,?,?,?,?,?)";

            stmt = con.prepareStatement(sql);
            

            stmt.setInt(1, (maxId + 1));
            stmt.setString(2, name);
            stmt.setInt(3, age);
            stmt.setLong(4, aadhar);
            stmt.setInt(5,maxAddressId+1);
            stmt.setInt(6,maxContactId+1);
            stmt.setString(5, password);
            //stmt.setString(7, confirmPassword);
            System.out.println("Sql to execute=" + stmt);
            // execute SQL
            int i = stmt.executeUpdate();
           
            
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
