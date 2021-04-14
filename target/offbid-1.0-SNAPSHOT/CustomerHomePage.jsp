<%-- 
    Document   : CustomerHomePage
    Created on : Mar 19, 2021, 2:01:05 PM
    Author     : Sourav
--%>

<%@page import="FarmCon.com.beans.Customer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Customer</title>
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
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
<!--        <header id="header" class="fixed-top ">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/FarmCon_Logo.png" alt=""></a>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                 <li class="active"><a href="#">Welcome: </a></li>
                                <li><a href="CustomerHomePage.jsp">Home</a></li>
                                <li><a href="ShowAuctionProduct">Auction</a></li>
                                <li><a href="#" onclick="myFunction()">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header>-->
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <div class="card-body light">
                           <h1>FarmCon - The Farm Connection</h1>
                           <h2>We Provide Direct Access To Farmers And Their Products.</h2>
                        </div>
                    </div>
                </div>
            </div>
        </section>
<!--        <script>
        function myFunction() {
         if(confirm("You Will Be Logged Out!\n Do You Want To Continue?"))
         {
            location='Logout';
         }
        else {
            location= 'CustomerHomePage.jsp';
        } 
        }
        </script>-->
    </body>
</html>
