<%-- 
    Document   : CustomerBid_NoAuction
    Created on : Mar 19, 2021, 2:01:05 PM
    Author     : Sourav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry!</title>
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
        <header id="header" class="fixed-top ">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/FarmCon_Logo.png" alt=""></a>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                <li class=""><a href="HomePage.jsp">Home</a></li>
                                <li class="active"><a href="ShowAuctionProduct">Auction</a></li>
                                <li><a href="#Logout">Logout</a></li>
                            </ul>
                        </nav><!-- .nav-menu -->
                    </div>
                </div>
            </div>
        </header>
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <div class="card-body light">
                            <h1>There is no live auction now. Please try again later.</h1>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    </body>
</html>
