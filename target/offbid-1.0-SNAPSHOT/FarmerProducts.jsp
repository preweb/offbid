<%-- 
    Document   : FarmerProducts
    Created on : 18 Mar, 2021, 11:38:28 PM
    Author     : kunal
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<%@page import="FarmCon.com.beans.Product"%>

<%--<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head >
        <title>Farmer Products</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"><link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Template Main CSS File -->
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
    <body>
       <div id="header"></div>
        <script>
           $(document).ready(function () {
            $("#header").load("BaseTemplate_Farmer.jsp");
            });
        </script>  
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <h2 style="text-align: left; font-size: 34px; font-family: sans-serif">Send For Auction</h2>
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <form method="POST" action="FarmerOptForAuction">
                            <table class="table">
                                <c:set var="arraylist" value="${arraylist}" scope="session" />
                                <thead style="background-color: #778899">
                                    <!--Table Columns For Farmer Products-->
                                    <tr>
                                        <th>Product ID</th>
                                        <th>Name</th>
                                        <th>Unit Price(INR)</th>
                                        <th>Max Quantity(Kilograms)</th>
                                    </tr>
                                </thead>
                                <tbody style="background-color: #8FBC8F">

                                    <c:forEach items="${sessionScope.arraylist}" var = "list">
                                        <tr>
                                            <td>
                                                <div class="radio" required="">
                                                    <label><input type="radio" id='opt' name="optradio" value="${list.productID}"> ${list.productID}</label>
                                                </div>
                                            </td>
                                            <td>${list.name}</td>
                                            <td>&#8360 ${list.unitPrice}</td>
                                            <td>${list.maxQuantity} Kg</td>
                                        </tr>
                                    </c:forEach>

                                </tbody>
                            </table>
                            <!--Button for sending data to database-->
                            <!--                        <input type="Submit" value="Submit" class="button1">-->
                            <button type="Submit" class="button button1">Submit</button>
                        </form>
                    </div>
                </div>
            </div>
        </section><!-- End Hero -->
    </body>
</html>
