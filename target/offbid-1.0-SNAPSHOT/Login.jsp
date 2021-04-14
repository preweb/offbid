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
        <!--<link rel="stylesheet" href="css/login.css">-->
        <link href="css/mainStyleSheet.css" rel="stylesheet">
        <title>Login Form</title>
    </head>
    <body>
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-8"  style="background-color: #439a48; opacity: 0.85; padding: 20px;">
                         <h1 class="h3 mb-3 font-weight-normal" style="text-align: center;"> Sign in</h1>
                         <label class="control-label" id="users" for="users"><Strong>Login As:</strong></label>
                        <form class="form-horizontal" method="post" action="Login">
                           
                            <select required="" class="form-control col-sm-4 " id="select" name="user" style="margin-left: 35%;">
                                <option value="select">--Select--</option>
                                <option value="farmer">Farmer</option>
                                <option value="customer">Customer</option>
                            </select>
                            <input name="emailAddress" type="email"  class="form-control" placeholder="Email address" required="" autofocus="">
                            <input name="password" type="password"  class="form-control" placeholder="Password" required="">

                            <button class="btn btn-success btn-block" style="background-color: #239e20" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
                            <label class="control-label col-sm-2">or</label>
                            <button class="btn btn-dark btn-block" style="background-color: #3b5998" type="button"><a href="SignUp.jsp" style="color: lime;">Sign up</a></button>

                        </form>
                    </div>
                </div>
            </div>
        </section><!-- End Hero -->
        <!--Footer-->
        <footer id="footer">
            <div class="container">
                <a href="AdminLogin.jsp"><strong><span>Admin Portal</span></strong></a>
            </div>
            <div class="copyright">
                &copy; Copyright <strong><span>FarmCon</span></strong>. All Rights Reserved
            </div>
        </footer><!-- End Footer -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script src="/script.js"></script>
    </body>
</html>