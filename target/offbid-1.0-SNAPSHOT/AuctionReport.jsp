<%-- 
    Document   : AuctionReport
    Created on : 17 Mar, 2021, 12:35:47 PM
    Author     : Pratip
--%>

<%@page import="FarmCon.com.beans.Bid"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auction Report</title>
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
    </head>
    <body class="farmer">
        <% ArrayList bidList=(ArrayList) request.getSession().getAttribute("bidList");
           Iterator itr=bidList.iterator(); 
        %>
        <header id="header" class="fixed-top">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/FarmCon_Logo.png"></a>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                <li><a href="FarmerHomePage.jsp">Home</a></li>
                                <li><a href="FarmerDisplayProducts">Products</a></li>
                                <li class="active"><a href="ShowBids">Auction</a></li>
                                <li><a href="Logout">Logout</a></li>
                            </ul>
                        </nav><!-- .nav-menu -->
                    </div>
                </div>
            </div>
        </header>
        <section id="hero" class="d-flex flex-column">
            <div class="container">
                 <div class="row justify-content-center">
        <form method="post" action="InsertInvoiceData">
            <table class="table-responsive table table-striped" style="max-height: 270px;">
                <thead style="color: #33ffb4; background-color: darkslategray;">
                <th>Select</th>
                <th>Customer Name</th>
                <th>Bid Amount</th>
                <th>Required Quantity</th>
                </thead>
                <tbody style="color: #fff;">
                    <% while(itr.hasNext())
                    {
                        Bid bid=(Bid)itr.next();
                    %>
                        <tr>
                            <td><input type="radio" id="1" name="select" value="<%= bid.getBidID() %>"></td>
                            <td><%= bid.getCustomerName() %></td>
                            <td><%= bid.getTotalAmount() %></td>
                            <td><%= bid.getRequiredQuantity() %></td>
                        </tr>
                    <%}%>
                </tbody> 
            </table> 
               <span>
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
                </span> 
            </form>
            </div>  
         </div>  
      </section>
    </body>
</html>
