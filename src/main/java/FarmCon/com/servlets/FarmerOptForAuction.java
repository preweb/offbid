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
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author kunal
 */
public class FarmerOptForAuction extends HttpServlet {

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
             InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
             Connection con=ConnectionManager.getConnection(inputFile);
             System.out.println("Connection Established");
            /* TODO output your page here. You may use following sample code. */
            
            String fetchActiveAuction = "select auction_id from auction where auction_id>0 and start<=curdate() and curdate()<=end and active=1";
            PreparedStatement ps = con.prepareStatement(fetchActiveAuction);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                 ServletContext sc1 = this.getServletContext();
                 RequestDispatcher rd = sc1.getRequestDispatcher("/AuctionStatus.jsp");
                 rd.forward(request, response);
            }
            else{
            int id = Integer.parseInt(request.getParameter("optradio"));
            
            String getMaxAuctionID="select max(auction_id) from auction";
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery(getMaxAuctionID);
            rs1.next();
            int maxAuctionID=rs1.getInt(1);
            
            String sql = "INSERT INTO auction VALUES(?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(sql);
           
            stmt.setInt(1, (maxAuctionID+1));
            Calendar calendarOriginal = Calendar.getInstance();
            java.sql.Date dateoriginal = new java.sql.Date(calendarOriginal.getTime().getTime());
            stmt.setDate(2, dateoriginal);
            
            int sec = 172800;
            calendarOriginal.add(Calendar.SECOND, sec);
            java.sql.Date dateLast = new java.sql.Date(calendarOriginal.getTime().getTime());
            stmt.setDate(3, dateLast);
            stmt.setInt(4, id);
            stmt.setInt(5, 1);
            int i = stmt.executeUpdate();
            System.out.println(i+"rows updated");
            
            ServletContext sc = this.getServletContext();
            RequestDispatcher rd = sc.getRequestDispatcher("/InterimPage.jsp");
            rd.forward(request, response);
            }
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
