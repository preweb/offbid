<%-- 
    Document   : Login
    Created on : 17 Mar, 2021, 8:22:48 PM
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
        <link rel="stylesheet" href="css/login.css">
        <link href="css/AdminProduct.css" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
        
        <title>Login Form</title>
    </head>
    <body class="admin">
        <section id="hero" class="d-flex flex-column justify-content-center">
            <div class="container">
                <div class="row justify-content-center">
                    <div class="col-xl-10">
                    
                        <div>
                            <form style="padding: 50px" class="form-horizontal" method="post" action="AdminLogin">
                                <h1  style="text-align: center;font-weight: bold;font-family: sans-serif;">Admin Login</h1>
                                
                                <input name="email_address" type="email" id="inputEmail" class="form-control" style="text-align: center; font-weight: bold;" placeholder="Email Address" required="" autofocus="">
                                
                                <input name="password" type="password" id="inputPassword" class="form-control" style="padding: 5px; text-align: center; font-weight: bold;" placeholder="Password" required="">
                                 <label class="control-label col-sm-4"><strong> </strong></label>
                                <button class="btn btn-success btn-block col-sm-4" type="submit"><i class="fas fa-sign-in-alt"></i> Sign in</button>
                            </form>                            
                        </div>
                    </div>
                </div>
        </section>

</body>
</html>