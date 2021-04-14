<%-- 
    Document   : SubmitBid
    Created on : 25 Mar, 2021, 6:31:31 PM
    Author     : kunal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        <!-- Template Main CSS File -->
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/icofont.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <script
            src="https://code.jquery.com/jquery-3.6.0.min.js">
            
        </script>
    </head>
    <body>
        <div id="header"></div>
        <script>
           $(document).ready(function () {
            $("#header").load("CustomerBaseTemplate.jsp");
            });
        </script>
        <!-- ======= Hero Section ======= -->
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="container">
                        
                            <form class="form-horizontal" style="background-color: #439a48; opacity: 0.85; padding: 20px; padding-bottom: 50px;" method="post" action="RegisterBid">

                                <div class="form-group">
                                    <label class="control-label col-sm-2"><strong>Base Unit Price:-</strong></label>  
                                    <div class="col-sm-10">          
                                        <input class="form-control" style="text-align: center; font-weight: bold; "  type="text"  disabled="true" value="<%= request.getParameter("unitPrice")%>">   
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2"><strong>Maximum Quantity Available:-</strong></label>  
                                    <div class="col-sm-10">          
                                        <input class="form-control" style="text-align: center; font-weight: bold;"   type="text" disabled="true" value="<%= request.getParameter("maxQuantity")%>">  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2"><strong>Offered Unit Price:-</strong></label>  
                                    <div class="col-sm-10">          
                                        <input class="form-control" style="text-align: center"   type="text" id="price" placeholder="Enter your unit price" oninput="calculateTotalBidAmount()">  
                                    </div>
                                </div>                  
                                <div class="form-group">
                                    <label class="control-label col-sm-2"><strong>Required Quantity:-</strong></label>  
                                    <div class="col-sm-10">          
                                        <input class="form-control" style="text-align: center"   type="text" id="quantity" name="quantity"  placeholder="Enter your required quantity" oninput="calculateTotalBidAmount()">  
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="control-label col-sm-2"><strong>Total Bid Amount:-</strong></label>  
                                    <div class="col-sm-10">          
                                        <input class="form-control" style="text-align: center; font-weight: bold;"   required="true" type="text" id="amount" name="amount" readonly="true">&nbsp;&nbsp;  
                                    </div>
                                </div> 
                                    <button class="form-control col-sm-4"  type="submit" value="Submit Bid" >Submit Bid</button>
                                    <label class="control-label col-sm-4"><strong>      </strong></label> 
                                    <button class="form-control col-sm-4"  type="reset" value="Reset">Reset</button> 
                            </form>
                       
                    </div>            
                </div>
            </div>
        </section><!-- End Hero -->
        
        <script>
            function calculateTotalBidAmount()
            {
                var price=document.getElementById("price").value;
                var quantity=document.getElementById("quantity").value;
                var result=price*quantity;
                document.getElementById("amount").value=result;
            }
              
        </script>
    </body>
</html>