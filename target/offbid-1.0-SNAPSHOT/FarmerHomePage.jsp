<%-- 
    Document   : FarmerHomePage
    Created on : 16 Mar, 2021, 11:14:39 PM
    Author     : kunal
--%>

<%@page import="FarmCon.com.beans.Farmer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome Farmer</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
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
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <h1>FarmCon - The Farm Connection</h1>
                        <h2>We Provide Direct Access To Farmers And Their Products.</h2>
                    </div>
                </div>
            </div>
        </section><!-- End Hero -->
    </body>
</html>
