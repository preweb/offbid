/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.services.Services;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pratip
 */
public class InsertInvoiceData extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, ClassNotFoundException, SQLException 
    {
        response.setContentType("text/html;charset=UTF-8");
        InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
       // String inputFile="C:\\Users\\Sourav\\Documents\\NetBeansProjects\\FarmCon-updated\\FarmCon\\web\\WEB-INF\\db_properties.properties";
        
        int selectedBidID=Integer.parseInt(request.getParameter("select"));
        int invoiceID=Services.insertInvoiceData(inputFile, selectedBidID);
        RequestDispatcher rd=request.getRequestDispatcher("ShowCongrats.jsp");
        rd.forward(request, response);
        
        /*response.sendRedirect("ShowCongrats.jsp");     
        HttpSession session=request.getSession();
        session.setAttribute("invoiceID", invoiceID);
        Services_old.generateInvoicePDF(filePath, invoiceID);
        Services_old.sendEmail(filePath, invoiceID);*/
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
        try 
        {
            processRequest(request, response);
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println(ex);
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
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
        try 
        {
            processRequest(request, response);
        } 
        catch (ClassNotFoundException ex) 
        {
            System.out.println(ex);
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
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
