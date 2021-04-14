<%-- 
    Document   : AdminViewFarmer
    Created on : Mar 16, 2021, 12:57:13 PM
    Author     : Sourav
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="FarmCon.com.beans.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Farmer View Admin Page</title>
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
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <h3 style="color:darkorange; font-size: 35px; padding-bottom: 20px;"><u>Farmer View</u></h3>
                <div class="row">

                    <div style="max-height: 500px;overflow: scroll;">
                      
                        <table class="table table-responsive-lg table-striped" style="color: #f0f0f0">
                         
                            <thead style="font-size : 15px; color:#33ffb4;background-color: darkslategray;"> 
                                <tr>
                                    <th>Farmer ID</th>
                                    <th>Farmer Name</th>
                                    <th>Age</th>
                                    <th>Email ID</th>
                                    <th>Phone Number</th>
                                    <th>Aadhar Number</th>
                                    <th>Address Line 1</th>
                                    <th>Address Line 2</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Country</th>
                                    <th>Pincode</th>
                                </tr>
                            </thead>
                            <tbody>
<%
    ArrayList farmerList = (ArrayList) request.getAttribute("farmers");
    Iterator itr = farmerList.iterator();
    while (itr.hasNext()) {
        Farmer farmer = (Farmer) itr.next();
        Contact farmerContact = (Contact) itr.next();
        Address farmerAddress = (Address) itr.next();
%>               
                                <tr style="font-size: 15px;">
                                    <td><%= farmer.getFarmerID()%></td>
                                    <td><%= farmer.getName()%></td>
                                    <td><%= farmer.getAge()%></td>
                                    <td><%= farmerContact.getEmailID()%></td>
                                    <td><%= farmerContact.getPhoneNo()%></td>
                                    <td><%= farmer.getAadhar()%></td>
                                    <td><%= farmerAddress.getLine1()%></td>
                                    <td><%= farmerAddress.getLine2()%></td>
                                    <td><%= farmerAddress.getCity()%></td>
                                    <td><%= farmerAddress.getState()%></td>
                                    <td><%= farmerAddress.getCountry()%></td>
                                    <td><%= farmerAddress.getPincode()%></td>
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
