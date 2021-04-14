/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FarmCon.com.services;

import FarmCon.com.beans.Auction;
import FarmCon.com.beans.Bid;
import FarmCon.com.beans.Product;
import FarmCon.com.connection.ConnectionManager;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author Pratip
 */

public class Services 
{
    public static ArrayList<Bid> getListOfBids(InputStream filePath) throws FileNotFoundException, SQLException, ClassNotFoundException, IOException
    {
        //InputStream inputFile = new FileInputStream("D:\\NetBeans Practice\\FARMCON\\web\\WEB-INF\\db_params.properties");
        
        Connection con=ConnectionManager.getConnection(filePath);
        //System.out.println("Connection established: "+con);
        ArrayList<Bid> bidList=new ArrayList<>();
        String fetchBids="select * from bid, customer where auction_id=(select auction_id from auction where auction_id>0 and start<=curdate() and curdate()<=end and active=1) and bid.customer_id=customer.customer_id";
        Statement st=con.createStatement();
        
        ResultSet rs=st.executeQuery(fetchBids);
        while(rs.next())
        {
            Bid bid=new Bid();
            bid.setBidID(rs.getInt("bid_id"));
            bid.setAuctionID(rs.getInt("auction_id"));
            bid.setCustomerID(rs.getInt("customer_id"));
            bid.setTotalAmount(rs.getDouble("total_amount"));
            bid.setRequiredQuantity(rs.getInt("required_quantity"));
            bid.setCustomerName(rs.getString("name"));
            //System.out.println(bid.getBidID());
            bidList.add(bid);
        }
        return bidList;
    }
    public static int insertInvoiceData(InputStream filePath, int bidID) throws ClassNotFoundException, IOException, SQLException
    {
        Connection con=ConnectionManager.getConnection(filePath);
        String fetchDetails="select bid.auction_id, bid.customer_id, customer.name, total_amount, customer.address_id, customer.contact_id, auction.product_id, product.name, product.description, product.farmer_id, farmer.name, required_quantity, farmer.address_id, farmer.contact_id from bid, customer, auction, product, farmer where bid_id=? and bid.customer_id=customer.customer_id and bid.auction_id=auction.auction_id and auction.product_id=product.product_id and product.farmer_id=farmer.farmer_id";
        PreparedStatement ps1=con.prepareStatement(fetchDetails);
        ps1.setInt(1, bidID);
        ResultSet rs1=ps1.executeQuery();
        rs1.next();
        //System.out.println(rs1.getInt("customer_id")+rs1.getInt("farmer_id")+rs1.getInt("product_id"));
        int auctionID=rs1.getInt("bid.auction_id");
        //System.out.println(auctionID);
        int customerID=rs1.getInt("customer_id");
        //System.out.println(customerID);
        String customerName=rs1.getString("customer.name");
        //System.out.println(customerName);
        double totalAmount=rs1.getDouble("total_amount");
        //System.out.println(customerAadhar);
        int customerAddressID=rs1.getInt("customer.address_id");
        //System.out.println(customerAddressID);
        String fetchCustomerAddress="select * from address where address_id=?";
        PreparedStatement ps2=con.prepareStatement(fetchCustomerAddress);
        ps2.setInt(1, customerAddressID);
        ResultSet rs2=ps2.executeQuery();
        rs2.next();
        String customerAddress=rs2.getString("line1")+", "+rs2.getString("line2")+", "+rs2.getString("city")+", "+rs2.getString("state")+", "+rs2.getString("country")+", "+rs2.getInt("pincode")+".";
        //System.out.println(customerAddress);
        int customerContactID=rs1.getInt("customer.contact_id");
        String fetchCustomerContact="select * from contact where contact_id=?";
        PreparedStatement ps3=con.prepareStatement(fetchCustomerContact);
        ps3.setInt(1, customerContactID);
        ResultSet rs3=ps3.executeQuery();
        rs3.next();
        String customerEmail=rs3.getString("email_id");
        long customerPhone=rs3.getLong("phone_no");
        int productID=rs1.getInt("auction.product_id");
        String productName=rs1.getString("product.name");
        String productDescription=rs1.getString("product.description");
        int farmerID=rs1.getInt("product.farmer_id");
        String farmerName=rs1.getString("farmer.name");
        int requiredQuantity=rs1.getInt("required_quantity");
        int farmerAddressID=rs1.getInt("farmer.address_id");
        String fetchFarmerAddress="select * from address where address_id=?";
        PreparedStatement ps4=con.prepareStatement(fetchFarmerAddress);
        ps4.setInt(1, farmerAddressID);
        ResultSet rs4=ps4.executeQuery();
        rs4.next();
        String farmerAddress=rs4.getString("line1")+", "+rs4.getString("line2")+", "+rs4.getString("city")+", "+rs4.getString("state")+", "+rs4.getString("country")+", "+rs4.getInt("pincode")+".";
        int farmerContactID=rs1.getInt("farmer.contact_id");
        String fetchFarmerContact="select * from contact where contact_id=?";
        PreparedStatement ps5=con.prepareStatement(fetchFarmerContact);
        ps5.setInt(1, farmerContactID);
        ResultSet rs5=ps5.executeQuery();
        rs5.next();
        String farmerEmail=rs5.getString("email_id");
        long farmerPhone=rs5.getLong("phone_no");
        String getMaxInvoiceID="select max(invoice_id) from invoice";
        Statement st=con.createStatement();
        ResultSet rs6=st.executeQuery(getMaxInvoiceID);
        rs6.next();
        int maxInvoiceID=rs6.getInt(1);
        String insertData="insert into invoice values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps6=con.prepareStatement(insertData);
        ps6.setInt(1, maxInvoiceID+1);
        ps6.setInt(2, auctionID);
        ps6.setInt(3, customerID);
        ps6.setString(4, customerName);
        ps6.setDouble(5, totalAmount);
        ps6.setString(6, customerAddress);
        ps6.setString(7, customerEmail);
        ps6.setLong(8, customerPhone);
        ps6.setInt(9, productID);
        ps6.setString(10, productName);
        ps6.setString(11, productDescription);
        ps6.setInt(12, farmerID);
        ps6.setString(13, farmerName);
        ps6.setInt(14, requiredQuantity);
        ps6.setString(15, farmerAddress);
        ps6.setString(16, farmerEmail);
        ps6.setLong(17, farmerPhone);
        ps6.executeUpdate();
        String updateActiveStatus = "update auction set active=0 where auction_id=?";
        PreparedStatement pss=con.prepareStatement(updateActiveStatus);
        pss.setInt(1, auctionID);
        pss.executeUpdate();
        //generateInvoicePDF(filePath, maxInvoiceID+1);
        return (maxInvoiceID+1);
    }
    public static int generateInvoicePDF(InputStream filePath) throws DocumentException
    {
       
        try 
        {
            Connection con=ConnectionManager.getConnection(filePath);
            String getInvoiceID="select max(invoice_id) from invoice";
            Statement st=con.createStatement();
            ResultSet rs2=st.executeQuery(getInvoiceID);
            rs2.next();
            int invoiceID=rs2.getInt(1);
            //System.out.println(invoiceID);
            String fetchInvoiceData="select customer_name, customer_address, customer_email, customer_phone, product_name, product_description, total_amount, required_quantity, farmer_name, farmer_address, farmer_email, farmer_phone from invoice where invoice_id=?";
            PreparedStatement ps=con.prepareStatement(fetchInvoiceData);
            ps.setInt(1, invoiceID);
            ResultSet rs=ps.executeQuery();
            rs.next();
            Document document=new Document(PageSize.A4, 97, 97, 97, 97);
            PdfWriter writer=PdfWriter.getInstance(document, new FileOutputStream("/invoices/Invoice_"+invoiceID+".pdf"));
            Font font=FontFactory.getFont(FontFactory.COURIER, (float) 10, Font.BOLD);
            Font font2=FontFactory.getFont(FontFactory.TIMES, 8);
            Image logo=Image.getInstance("/images/FarmCon_Logo.png");
            //logo.setAlignment(1);
            //Fixed Positioning
            logo.setAbsolutePosition(200, (float) 694);
            //Scale to new height and new width of image
            logo.scaleAbsolute(280, 200);
            //Add to document
            document.open();
            document.add(logo);
            PdfPTable invoiceTable = new PdfPTable(2); // 2 columns.
            invoiceTable.setWidthPercentage(100); //Width 100%
            /*table.setSpacingBefore(10); //Space before table
            table.setSpacingAfter(10);*/ //Space after table
            PdfPCell invID = new PdfPCell(new Paragraph("Invoice ID", font));
            //cell1.setBorderColor(BaseColor.BLUE);
            invID.setPadding(10);
            invID.setHorizontalAlignment(Element.ALIGN_CENTER);
            invID.setVerticalAlignment(Element.ALIGN_MIDDLE);
            invoiceTable.addCell(invID);
            PdfPCell date=new PdfPCell(new Paragraph("Timestamp", font));
            date.setPadding(10);
            date.setHorizontalAlignment(Element.ALIGN_CENTER);
            date.setVerticalAlignment(Element.ALIGN_MIDDLE);
            invoiceTable.addCell(date);
            PdfPCell invIDValue = new PdfPCell(new Paragraph(Integer.toString(invoiceID), font));
            invIDValue.setPadding(10);
            invIDValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            invIDValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            invoiceTable.addCell(invIDValue);
            PdfPCell dateValue=new PdfPCell(new Paragraph(String.valueOf(new Date()), font));
            dateValue.setPadding(10);
            dateValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            dateValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            invoiceTable.addCell(dateValue);
            document.add(invoiceTable);
            Paragraph newLine1=new Paragraph("\n \n");
            document.add(newLine1);
            
            PdfPTable farmerTable=new PdfPTable(1);
            String farmerDetails=rs.getString("farmer_name")+"\n\n"+rs.getString("farmer_address")+"\n\n"+rs.getString("farmer_email")+"\n\n"+rs.getLong("farmer_phone");
            PdfPCell soldBy=new PdfPCell(new Paragraph("Sold By:-", font));
            soldBy.setPadding(10);
            soldBy.setHorizontalAlignment(Element.ALIGN_CENTER);
            soldBy.setVerticalAlignment(Element.ALIGN_MIDDLE);
            farmerTable.addCell(soldBy);
            PdfPCell soldByValue=new PdfPCell(new Paragraph(farmerDetails, font));
            soldByValue.setPadding(10);
            soldByValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            soldByValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            farmerTable.addCell(soldByValue);
            document.add(farmerTable);
            Paragraph newLine2=new Paragraph("\n \n");
            document.add(newLine2);
            
            PdfPTable customerTable=new PdfPTable(1);
            String customerDetails=rs.getString("customer_name")+"\n\n"+rs.getString("customer_address")+"\n\n"+rs.getString("customer_email")+"\n\n"+rs.getLong("customer_phone");
            PdfPCell bill=new PdfPCell(new Paragraph("Billing Details:-", font));
            bill.setPadding(10);
            bill.setHorizontalAlignment(Element.ALIGN_CENTER);
            bill.setVerticalAlignment(Element.ALIGN_MIDDLE);
            customerTable.addCell(bill);
            PdfPCell billValue=new PdfPCell(new Paragraph(customerDetails, font));
            billValue.setPadding(10);
            billValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            billValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            customerTable.addCell(billValue);
            document.add(customerTable);
            Paragraph newLine3=new Paragraph("\n \n");
            document.add(newLine3);
            
            PdfPTable productTable=new PdfPTable(4);
            
            PdfPCell productName=new PdfPCell(new Paragraph("Product Name", font));
            productName.setPadding(10);
            productName.setHorizontalAlignment(Element.ALIGN_CENTER);
            productName.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(productName);
            
            PdfPCell productDescription=new PdfPCell(new Paragraph("Product Description", font));
            productDescription.setPadding(10);
            productDescription.setHorizontalAlignment(Element.ALIGN_CENTER);
            productDescription.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(productDescription);
            
            PdfPCell requiredQuantity=new PdfPCell(new Paragraph("Ordered Quantity", font));
            requiredQuantity.setPadding(10);
            requiredQuantity.setHorizontalAlignment(Element.ALIGN_CENTER);
            requiredQuantity.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(requiredQuantity);
            
            PdfPCell totalAmount=new PdfPCell(new Paragraph("Total Amount", font));
            totalAmount.setPadding(10);
            totalAmount.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalAmount.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(totalAmount);
            
            PdfPCell productNameValue=new PdfPCell(new Paragraph(rs.getString("product_name"), font));
            productNameValue.setPadding(10);
            productNameValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            productNameValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(productNameValue);
            
            PdfPCell productDescriptionValue=new PdfPCell(new Paragraph(rs.getString("product_description"), font));
            productDescriptionValue.setPadding(10);
            productDescriptionValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            productDescriptionValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(productDescriptionValue);
            
            PdfPCell requiredQuantityValue=new PdfPCell(new Paragraph(Integer.toString(rs.getInt("required_quantity")), font));
            requiredQuantityValue.setPadding(10);
            requiredQuantityValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            requiredQuantityValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(requiredQuantityValue);
            
            PdfPCell totalAmountValue=new PdfPCell(new Paragraph(Double.toString(rs.getDouble("total_amount")), font));
            totalAmountValue.setPadding(10);
            totalAmountValue.setHorizontalAlignment(Element.ALIGN_CENTER);
            totalAmountValue.setVerticalAlignment(Element.ALIGN_MIDDLE);
            productTable.addCell(totalAmountValue);
            
            document.add(productTable);
            Paragraph newLine4=new Paragraph("\n \n");
            document.add(newLine4);
            
            Paragraph newLine5=new Paragraph("\n \n");
            Paragraph disclaimer=new Paragraph("Disclaimer:- The product pricing has been finalized with the mutual consent of both the parties. FarmCon is not responsible for any discrepancies arised later.", font2);
            //disclaimer.setAlignment(100);
            document.add(newLine5);
            document.add(disclaimer);
            //writer.close();
            document.close();
            
            return invoiceID;
        } 
        catch (FileNotFoundException ex) 
        {
            System.out.println(ex);
        } 
        catch (IOException ex) 
        {
            System.out.println(ex);
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
        
        } catch (BadElementException ex) {
            Logger.getLogger(Services.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
    public static void sendEmail(String filePath, int invoiceID) throws ClassNotFoundException, IOException, SQLException, NullPointerException
    {
        Connection con=ConnectionManager.getConnection(filePath);
        //System.out.println(con);
        String fetchEmails="select customer_email, farmer_email from invoice where invoice_id=?";
        PreparedStatement ps=con.prepareStatement(fetchEmails);
        ps.setInt(1, invoiceID);
        ResultSet rs=ps.executeQuery();
        rs.next();
        String to=rs.getString("customer_email");
        System.out.println(to);
        String cc=rs.getString("farmer_email");
        System.out.println(cc);
        final String from="farmconofficial@yahoo.com";
        final String password="gywyeojkcryvrkoa";
        //final String password="OfficialConFarm1234";
        final String host="smtp.mail.yahoo.com";
        Properties emailProperties=new Properties();
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true"); 
        emailProperties.put("mail.smtp.host", host);
        emailProperties.put("mail.smtp.port", "587");
        Session session = Session.getInstance(emailProperties, new Authenticator() 
        {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() 
            {
                return new PasswordAuthentication(from, password);
            }
        });
        
        try 
        {
            MimeMessage message=new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setSubject("Invoice");
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setRecipient(Message.RecipientType.CC, new InternetAddress(cc));
            MimeBodyPart text=new MimeBodyPart();
            text.setText("Please find invoice no "+invoiceID+" attached.");
            MimeBodyPart attachment=new MimeBodyPart();
            String attachedFile="C:\\Users\\Sourav\\Documents\\NetBeansProjects\\FarmCon-updated\\FarmCon\\invoices\\Invoice_1.pdf";
            FileDataSource source=new FileDataSource(attachedFile);
            attachment.setDataHandler(new DataHandler(source));
            attachment.setFileName("Invoice_"+invoiceID+".pdf");
            MimeMultipart multipart=new MimeMultipart();
            multipart.addBodyPart(text);
            multipart.addBodyPart(attachment);
            message.setContent(multipart);
            System.out.println("Sending in progress...");
            Transport.send(message);
            System.out.println("Email sent successfully!");
            
        } 
        catch (AddressException ex) 
        {
            System.out.println(ex);
        } 
        catch (MessagingException ex) 
        {
            System.out.println(ex);
        }
    }
    public static ArrayList getAuctionProduct(InputStream filePath)
    {
        try 
        {
            ArrayList list=new ArrayList();
            Connection con=ConnectionManager.getConnection(filePath);
            String fetchAuctionDetails="select * from auction where auction_id>0 and start<=curdate() and curdate()<=end and active=1";
            Statement st=con.createStatement();
            ResultSet rs1=st.executeQuery(fetchAuctionDetails);
            if(rs1.next())
            {
                Auction auction=new Auction();
                auction.setAuctionID(rs1.getInt("auction_id"));
                auction.setProductID(rs1.getInt("product_id"));
                auction.setStart(rs1.getDate("start"));
                auction.setEnd(rs1.getDate("end"));
                int auctionProductID=rs1.getInt("product_id");
                String fetchProductDetails="select * from product where product_id=?";
                PreparedStatement ps=con.prepareStatement(fetchProductDetails);
                ps.setInt(1, auctionProductID);
                ResultSet rs2=ps.executeQuery();
                rs2.next();
                Product product=new Product();
                product.setProductID(auctionProductID);
                product.setName(rs2.getString("name"));
                product.setDescription(rs2.getString("description"));
                product.setUnitPrice(rs2.getDouble("unit_price"));
                product.setMaxQuantity(rs2.getInt("max_quantity"));
                product.setFarmerID(rs2.getInt("farmer_id"));
                list.add(auction);
                list.add(product);
                return list;
            }
            else
                return null;
            
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
            return null;
        }
        
    }
    public static boolean insertBidData(InputStream filePath, int customerId, int requiredQuantity, double totalBidAmount)
    {
        try
        {
            Connection con=ConnectionManager.getConnection(filePath);
            String fetchMaxBidID="select max(bid_id) from bid";
            Statement st1=con.createStatement();
            ResultSet rs1=st1.executeQuery(fetchMaxBidID);
            rs1.next();
            int maxBidID=rs1.getInt(1);
            String fetchAuctionID="select auction_id from auction where auction_id>0 and start<=curdate() and curdate()<=end and active=1";
            Statement st2=con.createStatement();
            ResultSet rs2=st2.executeQuery(fetchAuctionID);
            rs2.next();
            int auctionID=rs2.getInt(1);
            String insertData="insert into bid values(?, ?, ?, ?, ?)";
            PreparedStatement ps=con.prepareStatement(insertData);
            ps.setInt(1, maxBidID+1);
            ps.setInt(2, auctionID);
            ps.setInt(3, customerId);
            ps.setDouble(4, totalBidAmount);
            ps.setInt(5, requiredQuantity);
            System.out.println("Inserting data...");
            ps.executeUpdate();
            System.out.println("Data insertion successful!");
            return true;
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex);
            return false;
        }
        
    }
}
