<%-- 
    Document   : InterimPage
    Created on : 20 Mar, 2021, 1:39:47 AM
    Author     : kunal
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
        <title>Congratulations</title>
    </head>
    <body>
        <header id="header" class="fixed-top ">
            <div class="container-fluid">
                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/FarmCon_Logo.png" alt=""></a>
                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                                <li><a href="FarmerHomePage.jsp">Home</a></li>
                                <li><a href="#" onclick="myFunction()">Logout</a></li>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>
        </header>
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8">
                        <h1>You have successfully registered your bid. Thanks for participating!</h1>
                       
                    </div>
                </div>
            </div>
        </section><!-- End Hero -->
        <script>
        function myFunction() {
         if(confirm("You Will Be Logged Out!\n Do You Want To Continue?"))
         {
            location='Logout';
         }
        else {
            location= 'CustomerHomePage.jsp';
        } 
        }
        </script>
    </body>
</html>
