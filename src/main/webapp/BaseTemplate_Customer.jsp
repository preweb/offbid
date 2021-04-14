<%@page import="FarmCon.com.beans.Customer"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

 <%
            Customer customer = (Customer)request.getSession().getAttribute("customer");
 %>
              
        <!-- ======= Header ======= -->
        <header id="header" class="fixed-top ">
            <div class="container-fluid">

                <div class="row justify-content-center">
                    <div class="col-xl-9 d-flex align-items-center justify-content-between">
                        <a href="" class="logo"><img src="images/logo.png" alt=""></a>
<!--                        <h1 class="logo"><a href="">FarmCon</a></h1>-->
                        <!-- Uncomment below if you prefer to use an image logo -->
                       

                        <nav class="nav-menu d-none d-lg-block">
                            <ul>
                               <li class="active"><a href="#">Welcome: <%= customer.getName()%></a></li>
                                <li><a href="CustomerHomePage.jsp">Home</a></li>
                                <li><a href="ShowAuctionProduct">Auction</a></li>
                                <li><a href="#" onclick="myFunction()">Logout</a></li>
                            </ul>
                        </nav><!-- .nav-menu -->
                    </div>
                </div>

            </div>
        </header><!-- End Header -->
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

