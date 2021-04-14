<%-- 
    Document   : PreBid
    Created on : 23 Mar, 2021, 1:26:28 AM
    Author     : Pratip
--%>

<%@page import="FarmCon.com.beans.Auction"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FarmCon.com.beans.Product"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Details</title>
    </head>
    <body>
        <h3>Live Auction</h3>
        <% ArrayList list=(ArrayList)request.getSession().getAttribute("list");
           Auction auction=(Auction)list.get(0);
           Product product=(Product)list.get(1);%>
        <form method="post" action="SubmitBid.jsp">
            <table>
                <tr>
                    <td><img src="images/auction-hammer.png" alt="Auction" height="300" width="500"></td>
                </tr>
                <tr>
                    <td><strong><%= product.getName() %></strong></td>
                </tr>
                <tr>
                    <td><strong><%= product.getDescription()%></strong></td>
                </tr>
                <tr>
                    <td><strong><%= auction.getStart()+"-"+auction.getEnd() %></strong></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Proceed to Bid"></td>
                </tr>
            </table>
                <input type="hidden" name="unitPrice" value="<%= product.getUnitPrice() %>">
                <input type="hidden" name="maxQuantity" value="<%= product.getMaxQuantity() %>">
        </form>
    </body>
</html>
