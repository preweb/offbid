/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.servlets;

import FarmCon.com.services.Services;
import com.itextpdf.text.DocumentException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pratip
 */
public class SendInvoice extends HttpServlet 
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    {
        try {
            response.setContentType("text/html;charset=UTF-8");
            InputStream inputFile = getServletContext().getResourceAsStream("/WEB-INF/db_properties.properties");
            String filePath="C:\\Users\\Sourav\\Documents\\NetBeansProjects\\FarmCon-updated\\FarmCon\\config\\db_properties.properties";
            
            /*int invoiceID=(int)request.getSession().getAttribute("invoiceID");
            System.out.println(invoiceID);*/
            int invoiceID=Services.generateInvoicePDF(inputFile);
            Services.sendEmail(filePath, invoiceID);
            ServletContext sc1 = this.getServletContext();
            RequestDispatcher rd = sc1.getRequestDispatcher("/SuccessfulBid.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException | IOException | SQLException | NullPointerException ex) {
           ex.printStackTrace();
        } catch (ServletException ex) {
            ex.printStackTrace();
        } catch (DocumentException ex) {
            Logger.getLogger(SendInvoice.class.getName()).log(Level.SEVERE, null, ex);
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
    {
//        try 
//        {
            processRequest(request, response);
        //} 
//        catch (SQLException | ClassNotFoundException | ServletException | IOException ex) 
//        {
//            System.out.println(ex);
//        }
//        catch (FileNotFoundException ex) 
//        {
//            System.out.println(ex);
//        } 
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
    {
//        try 
//        {
            processRequest(request, response);
//        } 
//        catch (SQLException | ClassNotFoundException | ServletException | IOException ex) 
//        {
//            System.out.println(ex);
//        }
//        catch (FileNotFoundException ex) 
//        {
//            System.out.println(ex);
//        } 
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
