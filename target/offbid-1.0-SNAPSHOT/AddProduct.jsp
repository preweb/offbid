<%-- 
    Document   : AddProduct
    Created on : 17 Mar, 2021, 10:22:33 PM
    Author     : ANIRBAN
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Farmcon</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <!--Font-->
        <link href="vendor/mdi-font/css/material-design-iconic-font.min.css" rel="stylesheet" media="all">
        <link href="vendor/font-awesome-4.7/css/font-awesome.min.css" rel="stylesheet" media="all">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/AdminProduct.css" rel="stylesheet">
        <link href="css/mainStyleSheet.css" rel="stylesheet">

    </head>
    <body class="product">
        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top ">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/logo.png" alt=""></a>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                <li><a href=BaseTemplate.jsp>Home</a></li>
                                <li><a href="FarmerDisplayProducts"> Show Products</a></li>
                                <li><a href="ShowBids">Auction Report</a></li>
                                <li><a href="Logout">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>

            </div>
        </header><!-- End Header -->

        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container" style="margin-top: 20px;">
                    <div class="wrapper wrapper--w780">
                        <div class="card card-3">
                            <div class="card-heading"></div>
                            <div class="card-body">
                                <h2 class="title">Product Registration Form</h2>
                                <form method="POST" action="AddProduct">
                                    <div class="input-group">
                                        <input class="input--style-3" type="text" placeholder="Product Name" name="pname">
                                    </div>
                                    <div class="input-group">
                                        <input class="input--style-3" type="text" placeholder="Product Description" name="pdesc">
                                    </div>
                                    <div class="input-group">
                                        <input class="input--style-3" type="text" placeholder="Unit Price" name="punit">
                                    </div>
                                    <div class="input-group">
                                        <input class="input--style-3" type="text" placeholder="Maximum Quantity" name="pquant">
                                    </div>
                                    <div class="p-t-10">
                                        <button class="btn btn--pill btn--green" type="submit">Add Product</button>
                                    </div>
                                </form>
                            </div>
                        
                    </div>
                </div>

            </div>
        </section>