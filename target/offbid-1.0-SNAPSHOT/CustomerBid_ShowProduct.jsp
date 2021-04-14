<%-- 
    Document   : CustomerBid_ShowProduct
    Created on : Mar 19, 2021, 2:01:05 PM
    Author     : Sourav
--%>

<%@page import="FarmCon.com.beans.Product"%>
<%@page import="FarmCon.com.beans.Auction"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Live Now!</title>
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/ButtonFarmer.css" rel="stylesheet">
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous">
        </script>
    </head>
    <body class="customer">
        <div id="header"></div>
        <script>
           $(document).ready(function () {
            $("#header").load("BaseTemplate_Customer.jsp");
            });
        </script>
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                         
        <% ArrayList list=(ArrayList)request.getSession().getAttribute("list");
           Auction auction=(Auction)list.get(0);
           Product product=(Product)list.get(1);%>
        <form method="post" action="SubmitBid.jsp">
             <h3 style="color: white;">Live Auction</h3>
             <div class="card" style="max-height: 350px;">
                 <img src="images/auction-hammer.png" alt="Auction" height="130" width="300">
                 <table class="table table-responsive-sm" style="padding: 10px;">
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
                    <td><input type="submit" class="button" value="Proceed to Bid"></td>
                </tr>
            </table>
           </div>
                <input type="hidden" name="unitPrice" value="<%= product.getUnitPrice() %>">
                <input type="hidden" name="maxQuantity" value="<%= product.getMaxQuantity() %>">
        </form>
              </div>
            </div>
        </section>
    </body>
</html>
