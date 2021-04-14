<%-- 
    Document   : AuctionStatus
    Created on : Mar 26, 2021, 8:49:19 PM
    Author     : Sourav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
        <link href="css/ButtonFarmer.css" rel="stylesheet">
        <title>Sorry!</title>
    </head>
    <body>
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <h1>Already an auction is going on. Please try again later!</h1>
                        <form method="POST" action="FarmerHomePage.jsp">
                            <button type="Submit" class="button button1">Home</button>
                        </form>
                    </div>
                </div>
            </div>
        </section><!-- End Hero -->
    </body>
</html>
