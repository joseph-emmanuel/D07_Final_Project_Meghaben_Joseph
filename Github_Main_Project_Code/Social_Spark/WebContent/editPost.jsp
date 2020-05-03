<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Edit Post</title>
</head>
<body>
<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-light" style="border-bottom: solid 1px">
        <a href="#" class="navbar-brand"><img src="./resource/Images/social-spark-logo.png" style="width:80%"/></a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link">Home</a>
                <a href="#" class="nav-item nav-link active">Profile</a>
                <a href="#" class="nav-link nav-link" data-toggle="dropdown">Messages</a>                
            </div>            
            <div class="navbar-nav">
            <form class="form-inline">
                <div class="input-group">                    
                    <input type="text" class="form-control" placeholder="Search">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-secondary"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </form>
                <a href="LogoutServlet" class="nav-item nav-link">Logout</a>
            </div>
        </div>
    </nav>
</div>
<div class="container">

    <div class="row">
        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
        
            <div class="row">
                <div class="col-lg-6 col-md-8 mx-auto" style="opacity: 0.95;">
				
                    <!-- form card login -->
                    <div class="card rounded shadow shadow-sm">
                        <div class="card-header">
                            <h3 class="mb-0">Edit Post</h3>
                        </div>
                        <div class="card-body">
                            <form action="UpdatePost" class="form" role="form" autocomplete="off" id="formLogin" novalidate="" method="POST">
                                <div class="form-group">
                                    <textarea rows="5" cols="30" name="updateoption">${content}</textarea>
                                </div>
                                <div class="form-group">
                                    <input type="text" value="${id}" name ="id">
                                </div>                         
                                <button type="submit" class="btn btn-success btn-lg float-right" id="btnRegister">Login</button>
                            
                            </form>
                        </div>
                        <!--/card-block-->
                    </div>
                    <!-- /form card login -->

                </div>


            </div>
            <!--/row-->

        </div>
        <!--/col-->
    </div>
    <!--/row-->
</div>

<h1>this is a test</h1>
<form action="UpdatePost" method="post"> 
<textarea rows="5" cols="30" name="updateoption">${content}</textarea>
<input type="text" value="${id}" name ="id">
<input type="submit" value="submit"><br/> 
</form>
</body>
</html>
