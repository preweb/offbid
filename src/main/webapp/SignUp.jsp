<%-- 
    Document   : Regsiter
    Created on : 24 Mar, 2021, 2:18:20 PM
    Author     : HP
--%>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <link rel="stylesheet" href="css/signUp.css">
        
        
        <title>Register Form</title>
    </head>
    <body>
        
        <section id="hero" class="d-flex flex-column justify-content-center">
            <form method="get" action="SignUp">
                <div class="form-signin">
                    <h1 class="Sign"> Sign Up</h1>

                    <label id="users" for="users">Register As:</label>
                    <select id="User" name="user">
                        <option value="select">--Select--</option>
                        <option value="farmer">Farmer</option>
                        <option value="customer">Customer</option>

                    </select>
                    <div class="control-group">
                        <label class="control-label" for="inputFname1">Name <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="name" id="inputFname1" placeholder="Name">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputAge">Age <sup>*</sup></label>
                        <div class="controls">
                            <input type ="text" name="age" id="inputAge" placeholder="Age" >
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputAadhar">Aadhar <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="aadhar" id="inputAadhar" placeholder="Aadhar">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputLine1">Address Line1 <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="line1" id="inputLine1" placeholder="AddressLine1">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputLine2">Address Line2 <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="line2" id="inputLine2" placeholder="Address Line2">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputcity">City <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="city" id="inputcity" placeholder="City">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputState">State <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="state" id="inputState" placeholder="State">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputCountry">Country <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="country" id="inputLine2" placeholder="Country">
                        </div>
                    </div> 
                    <div class="control-group">
                        <label class="control-label" for="inputPincode">Pincode <sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="pincode" id="inputPincode" placeholder="Pincode">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputPhoneNo">Phone Number<sup>*</sup></label>
                        <div class="controls">        
                            <input type ="text" name="phone_no" id="inputPhoneNo" placeholder="Phone Number">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="input_email">Email <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="emailAddress" id="input_email" placeholder="Email">
                        </div>
                    </div>	  
                    <div class="control-group">
                        <label class="control-label" for="inputPassword1">Password <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="password" id="inputPassword1" placeholder="Password">
                        </div>
                    </div>
                    <div class="control-group">
                        <label class="control-label" for="inputConfirmPassword">Confirm Password <sup>*</sup></label>
                        <div class="controls">
                            <input type="text" name="confirmPassword" id="inputConfirmPassword" placeholder=" Confirm Password">
                        </div>
                    </div>

                    <button class="button" type="submit"><i class="fas fa-sign-in-alt"></i> Register</button>

                    <hr>
                    <!-- <p>Don't have an account!</p>  -->
                    <h6>Already have an account?</h6>
                    <button class="button" type="button" id="btn-signin"><a href="Login.jsp"><i class="fas fa-user-plus"></i>Login</a></button>

                </div>
            </form>
          
        </section>
        
    </body>
</html>
