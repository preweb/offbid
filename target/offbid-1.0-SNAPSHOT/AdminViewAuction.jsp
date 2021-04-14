<%-- 
    Document   : AdminViewAuction
    Created on : Mar 18, 2021, 2:32:44 PM
    Author     : hp
--%>

<%@page import="FarmCon.com.beans.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Auction View Admin Page</title>
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
                    <div>
                        <table class="table-responsive-lg table table-striped" style="color: #f0f0f0;">
                            <h3 style="color:darkorange;font-size: 35px;padding-bottom: 20px;margin-left: 50px;"><u>Auction View</u></h3>
                            <thead style="font-size : 15px; color:#33ffb4;background-color: darkslategray;">
                                <tr>
                                    <th>Auction ID</th>
                                    <th>Start</th>
                                    <th>End</th>
                                    <th>Product ID</th>
                                    <th>Product Name</th>
                                </tr>
                            </thead>
                            <tbody>

                                <%
                                    ArrayList auctionList = (ArrayList) request.getAttribute("auction");
                                    Iterator itr = auctionList.iterator();
                                    while (itr.hasNext()) {
                                       Auction auction = (Auction) itr.next();
                                       Product auctionProduct = (Product) itr.next();
                                %>               
                                <tr style="font-size: 15px;">
                                    <td><%= auction.getAuctionID()%></td>
                                    <td><%= auction.getStart()%></td>
                                    <td><%= auction.getEnd()%></td>
                                    <td><%= auctionProduct.getProductID()%></td>
                                    <td><%= auctionProduct.getName()%></td>
                                    
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
