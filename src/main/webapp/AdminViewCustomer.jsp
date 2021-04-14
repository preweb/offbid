<%-- 
    Document   : AdminViewCustomer
    Created on : Mar 17, 2021, 12:22:56 PM
    Author     : Sourav
--%>

<%@page import="FarmCon.com.beans.*"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer View Admin Page</title>
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
                <div class="row justify-content-center">
                    <h3 style="color:darkorange; font-size: 35px;padding-bottom: 20px;"><u>Customer View</u></h3>
                    <div style="max-height: 300px;overflow: scroll;">
                        <table class="table-responsive-lg table table-striped" style="color: #f0f0f0;">
                            
                            <thead style="font-size : 15px; color:#33ffb4; background-color: darkslategray;">
                                <tr>
                                    <th>Customer ID</th>
                                    <th>Customer Name</th>
                                    <th>Age</th>
                                    <th>Email ID</th>
                                    <th>Phone Number</th>
                                    <th>Aadhar Number</th>
                                    <th>Line 1</th>
                                    <th>Line 2</th>
                                    <th>City</th>
                                    <th>State</th>
                                    <th>Country</th>
                                    <th>Pincode</th>
                                </tr>
                            </thead>
                            <tbody>
<%
    ArrayList customerList = (ArrayList) request.getAttribute("customers");
    Iterator itr = customerList.iterator();
    while (itr.hasNext()) {
        Customer customer = (Customer) itr.next();
        Contact customerContact = (Contact) itr.next();
        Address customerAddress = (Address) itr.next();
%>               
                    <tr style="font-size: 15px;">
                        <td><%= customer.getCustomerID()%></td>
                        <td><%= customer.getName()%></td>
                        <td><%= customer.getAge()%></td>
                        <td><%= customerContact.getEmailID()%></td>
                        <td><%= customerContact.getPhoneNo()%></td>
                        <td><%= customer.getAadhar()%></td>
                        <td><%= customerAddress.getLine1()%></td>
                        <td><%= customerAddress.getLine2()%></td>
                        <td><%= customerAddress.getCity()%></td>
                        <td><%= customerAddress.getState()%></td>
                        <td><%= customerAddress.getCountry()%></td>
                        <td><%= customerAddress.getPincode()%></td>
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
