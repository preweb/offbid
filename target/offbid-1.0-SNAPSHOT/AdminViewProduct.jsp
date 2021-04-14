<%-- 
    Document   : FarmerProducts
    Created on : 18 Mar, 2021, 11:38:28 PM
    Author     : ANIRBAN
--%>
<%@page import="FarmCon.com.beans.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product View Admin Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/mainStyleSheet.css">
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/AdminProduct.css" rel="stylesheet">
    </head>
    <body class="admin">
        <!-- ======= Header ======= -->
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
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    
                    <div class="column-xl-8">
                        
                        <table class="table-responsive-lg table table-striped" style="color: #f0f0f0;">
                            
                            <thead style="font-size : 15px; color:#33ffb4;background-color: darkslategray;">
                                <tr><h3 style="color:darkorange;font-size: 35px;padding-bottom: 20px;margin-left: 50px;"><u>Product View</u></h3>
                            <thead style="font-size : 15px; color:#33ffb4;background-color: darkslategray;">
                                    <th>Product ID</th>
                                    <th>Product Name</th>
                                    <th>Product Description</th>
                                    <th>Unit Price</th>
                                    <th>Maximum Quantity</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    ArrayList ProductList = (ArrayList) request.getAttribute("product");
                                    Iterator itr = ProductList.iterator();
                                    while (itr.hasNext()) {
                                       Product product = (Product) itr.next();
                                %>               
                                <tr style="font-size: 15px;">
                                    <td><%= product.getProductID()%></td>
                                    <td><%= product.getName()%></td>
                                    <td><%= product.getDescription()%></td>
                                    <td><%= product.getUnitPrice()%></td>
                                    <td><%= product.getMaxQuantity()%></td>
                                </tr>
                                <%
                                    }
                                %>         
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
