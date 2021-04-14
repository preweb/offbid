

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.beans.Auction;
import FarmCon.com.beans.Product;
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

public class AdminViewAuction extends HttpServlet {

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
        String auctionTable = "select  auction.auction_id, auction.start,auction.end,product.product_id,product.name from auction.auction,auction.product where auction_id > 0 and auction.auction.product_id=auction.product.product_id";
            PreparedStatement stmt = con.prepareStatement(auctionTable);
            ResultSet rs = stmt.executeQuery();
            ArrayList auctionList = new ArrayList();
            while(rs.next()){
                System.out.println("Auction Table captured");
                Auction auction = new Auction();
                Product auctionProduct = new Product();
                auction.setAuctionID(rs.getInt("auction_id"));
                auction.setStart(rs.getDate("start"));
                auction.setEnd(rs.getDate("end"));
                auctionProduct.setProductID(rs.getInt("product_id"));
                auctionProduct.setName(rs.getString("name"));
                //Adding data to ArrayList
                auctionList.add(auction);
                auctionList.add(auctionProduct);
            }
            request.setAttribute("auction", auctionList);
            RequestDispatcher rd = request.getRequestDispatcher("AdminViewAuction.jsp");
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
    
