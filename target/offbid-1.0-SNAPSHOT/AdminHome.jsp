<%-- 
    Document   : BaseTemplate
    Created on : 16 Mar, 2021, 11:12:18 PM
    Author     : Anirban
--%>

<%@page import="FarmCon.com.beans.Administrator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Farmcon</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!--Font-->
        <!--<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">-->
        <!-- Template Main CSS File -->
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/AdminProduct.css" rel="stylesheet">
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        
    </head>
    <body class="admin">
 <% 
        Administrator admin = (Administrator)request.getSession().getAttribute("admin");
 %>
        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/logo.png" alt=""></a><h3 style="position: fixed;margin-left: 240px;color: #37f72b;font-weight: bold;font-family: sans-serif;"><i>Admin Portal</i></h3>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                <li class="active"><a href="#">Welcome: <%= admin.getName()%></a></li>
                                <li><a href="AdminHome.jsp">Dashboard</a></li>
                                <li><a href="Logout">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header><!-- End Header -->
  <!-- ======= Hero Section ======= -->
  <section id="hero" class="d-flex justify-content-center">
      <div class="container" >
<!--          <div class="container">-->
              <div class="row">

                <div class="col-md-auto">
                    <a href="AdminViewFarmer">
                        
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container-fluid">
                                <img style="max-width: 80px;" class="img-fluid rounded-circle" src="images/farmer.png" alt="farmer-icon">
                            </div>
                            <h1 class="text-uppercase" style="font-size:18px; color : #004085 ; margin-top: 2px;margin-bottom: 4px;">Farmer</h1>
                        </div>
                    </div>
                    </a>
                </div>
                <div class="col-md-auto">
                    <a href="AdminViewCustomer">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container-fluid">
                                <img style="max-width: 80px;" class="img-fluid rounded-circle" src="images/team.png" alt="customr-icon">
                            </div>
                            <h1 class="text-uppercase" style="font-size:18px; color : #004085 ;margin-top: 2px;margin-bottom: 4px;">Customer</h1>
                        </div>
                    </div>
                    </a>
                </div>  
                <div class="col-md-auto">
                    <a href="AdminViewProduct">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container-fluid">
                                <img style="max-width: 80px;" class="img-fluid rounded-circle" src="images/shipping.png" alt="product-icon">
                            </div>
                            <h1 class="text-uppercase" style="font-size:18px; color : #004085 ; margin-top: 2px;margin-bottom: 4px;">Product</h1>
                        </div>
                    </div>
                    </a>
                </div>  
                <div class="col-md-auto">
                    <a href="AdminViewAuction">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container-fluid">
                                <img style="max-width: 80px;" class="img-fluid rounded-circle" src="images/auction.png" alt="auction-icon">
                            </div>
                            <h1 class="text-uppercase" style="font-size:18px; color : #004085 ; margin-top: 2px;margin-bottom: 4px;">Auction</h1>
                        </div>
                    </div> 
                    </a>
                </div>
                <div class="col-md-auto">
                    <a href="AdminViewInvoice">
                    <div class="card">
                        <div class="card-body text-center">
                            <div class="container-md container-fluid">
                                <img style="max-width: 80px;" class="img-fluid rounded-circle" src="images/invoice.png" alt="invoice-icon">
                            </div>
                            <h1 class="text-uppercase" style="font-size:18px; color : #004085 ; margin-top: 2px;margin-bottom: 4px;">Invoice</h1>
                        </div>
                    </div>
                    </a>
                </div>
            </div>
<!--        </div>-->
  </div>
  </section><!-- End Hero -->
    </body>
</html>
