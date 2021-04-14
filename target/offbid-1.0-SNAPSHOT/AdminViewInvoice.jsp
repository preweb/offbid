<%-- 
    Document   : AdminViewInvoice
    Created on : Mar 20, 2021, 2:24:59 PM
    Author     : Sweety
--%>

<%@page import="FarmCon.com.beans.*"%>
<link href="css/invoiceTable_css.css" rel="stylesheet" id="bootstrap-css">
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Invoice view page for admin</title>
<!--        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/> 
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/AdminProduct.css" rel="stylesheet">
        <link rel="stylesheet" href="css/Policy_css.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha2/css/bootstrap.min.css" integrity="sha384-DhY6onE6f3zzKbjUPRc2hOzGAdEf4/Dz+WJwBvEYL/lkkIsI3ihufq9hk9K4lVoK" crossorigin="anonymous">        -->
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/mainStyleSheet.css">
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/AdminProduct.css" rel="stylesheet">
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"> 
        </script>
    </head>
    <body class="admin">
        <div id="header"></div>
        <header id="header" class="fixed-top ">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/logo.png" alt=""></a><h3 style="position: fixed;margin-left: 240px;color: #007bff;">Admin</h3>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                <li><a href="AdminHome.jsp">Dashboard</a></li>
                                <li><a href="#Logout">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header><!-- End Header -->
<section id="hero" class="d-flex flex-column justify-content-center">
    <div class="container">
        <div class="row justify-content-center">
<!--            <div class="col-xl-8">-->
        <h2 style="color:darkorange; font-size: 35px;padding-bottom: 20px;"> INVOICE TABLE </h2>
     <div style="max-height: 500px;overflow: scroll;">
    <table class="table table-responsive-lg table-striped" style="color: #f0f0f0">
            <thead style="font-size : 15px; color:#33ffb4;background-color: darkslategray;">
                <tr>
                    <th>Invoice ID</th>
                    <th>Product ID</th>
                    <th>Product Name</th>
                    <th>auction ID</th>
                    <th>Product Description</th>
                    <th>Customer ID</th>
                    <th>Customer Name</<th>
                    <th> Total Amount</th>
                   <th> Customer address</th>
                    <th>Customer email</<th>
                    <th> Customer phone</th>
                    <th>Farmer Id</th>
                    <th>Farmer Name</th>
                    <th>Required Quantity</th>
                    <th>Farmer Address</th>
                    <th>Farmer Email</th>
                    <th>Farmer Phone</th>
                </tr>
            </thead>
            <tbody>
<% 
    ArrayList invoiceList = (ArrayList)request.getAttribute("invoice");
    Iterator itr = invoiceList.iterator();
     while(itr.hasNext()){
        Invoice invoice = (Invoice)itr.next();
%>               
                <tr>
                    <td><%= invoice.getInvoiceID() %></td>
                    <td><%= invoice.getProductID() %></td>
                    <td><%= invoice.getProductName() %></td>
                    <td><%= invoice.getAuctionID() %></td>
                     <td><%= invoice.getProductDescription() %></td>
                    <td><%= invoice.getCustomerID() %></td>
                     <td><%= invoice.getCustomerName() %></td>
                      <td><%= invoice.getTotalAmount() %></td>
                      <td><%=invoice.getCustomerAddress() %>,
                      <td><%=invoice.getCustomerEmail()  %></td>
                      <td><%=invoice.getCustomerPhone() %></td>
                     <td><%= invoice.getFarmerID() %></td>
                     <td><%= invoice.getFarmerName() %></td>
                    <td><%= invoice.getRequiredQuantity() %></td>
                     <td><%=invoice.getFarmerAddress() %>,</td>
                    <td><%=invoice.getFarmerEmail()  %></td>
                      <td><%=invoice.getFarmerPhone() %></td>         
                </tr>
<% 
    }
%>                
            </tbody>
        </table>
    </div>
<!--            </div>-->
        </div>
    </section>
    </body>
</html>


