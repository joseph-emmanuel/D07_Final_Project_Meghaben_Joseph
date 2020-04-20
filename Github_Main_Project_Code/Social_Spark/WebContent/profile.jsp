<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="model.*" %>
    <%
    User user=(User)session.getAttribute("user");
    if(user==null){
    	response.sendRedirect("index.jsp");
    }
    
    
    %>
<!DOCTYPE html>
<html>
<head>
<style>
*{
    font-family: 'Open Sans', sans-serif;
}

.well {
    margin-top:-20px;
    background-color:#007FBD;
    border:2px solid #0077B2;
    text-align:center;
    cursor:pointer;
    font-size: 25px;
    padding: 15px;
    border-radius: 0px !important;
}

/*.well:hover {
    margin-top:-20px;
    background-color:#0077B2;
    border:2px solid #0077B2;
    text-align:center;
    cursor:pointer;
    font-size: 25px;
    padding: 15px;
    border-radius: 0px !important;
    border-bottom : 2px solid rgba(97, 203, 255, 0.65);
}*/

body {
font-family: "Helvetica Neue",Helvetica,Arial,sans-serif;
font-size: 14px;
line-height: 1.42857143;
color: #fff;
background-color: #F1F1F1;
}



.bg_blur
{
    background-image:url('http://data2.whicdn.com/images/139218968/large.jpg');
    height: 300px;
    background-size: cover;
}

.follow_btn {
    text-decoration: none;
    position: absolute;
    left: 35%;
    top: 42.5%;
    width: 35%;
    height: 15%;
    background-color: #007FBE;
    padding: 10px;
    padding-top: 6px;
    color: #fff;
    text-align: center;
    font-size: 20px;
    border: 4px solid #007FBE;
}

.follow_btn:hover {
    text-decoration: none;
    position: absolute;
    left: 35%;
    top: 42.5%;
    width: 35%;
    height: 15%;
    background-color: #007FBE;
    padding: 10px;
    padding-top: 6px;
    color: #fff;
    text-align: center;
    font-size: 20px;
    border: 4px solid rgba(255, 255, 255, 0.8);
}

.header{
    color : #808080;
    margin-left:10%;
    margin-top:70px;
}

.picture{
    height:150px;
    width:150px;
    position:absolute;
    top: 75px;
    left:-75px;
}

.picture_mob{
    position: absolute;
    width: 35%;
    left: 35%;
    bottom: 70%;
}

.btn-style{
    color: #fff;
    background-color: #007FBE;
    border-color: #adadad;
    width: 33.3%;
}

.btn-style:hover {
    color: #333;
    background-color: #3D5DE0;
    border-color: #adadad;
    width: 33.3%;
   
}


@media (max-width: 767px) {
    .header{
        text-align : center;
    }

    .nav{
        margin-top : 30px;
    }
}

</style>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="bs-example">
    <nav class="navbar navbar-expand-md navbar-light bg-light">
        <a href="#" class="navbar-brand">Brand</a>
        <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link active">Home</a>
                <a href="#" class="nav-item nav-link">Profile</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown">Messages</a>
                    <div class="dropdown-menu">
                        <a href="#" class="dropdown-item">Inbox</a>
                        <a href="#" class="dropdown-item">Sent</a>
                        <a href="#" class="dropdown-item">Drafts</a>
                    </div>
                </div>
            </div>
            <form class="form-inline">
                <div class="input-group">                    
                    <input type="text" class="form-control" placeholder="Search">
                    <div class="input-group-append">
                        <button type="button" class="btn btn-secondary"><i class="fa fa-search"></i></button>
                    </div>
                </div>
            </form>
            <div class="navbar-nav">
                <a href="#" class="nav-item nav-link">Login</a>
            </div>
        </div>
    </nav>
</div>
<div class="container" style="margin-top: 20px; margin-bottom: 20px;">
	<div class="row panel">
        <div class="col-md-8  col-xs-12">
           <img src="http://lorempixel.com/output/people-q-c-100-100-1.jpg" class="img-thumbnail picture hidden-xs" />
           <div class="header">
                <h1>${user.getFname()} ${user.getLname()}</h1>
                <h4>Web Developer</h4>
           </div>
        </div>
    </div>   
    
	<div class="row nav">    
        <div class="col-md-4"></div>
        <div class="col-md-8 col-xs-12" style="margin: 0px;padding: 0px;">
            <div class="col-md-6 col-xs-6 well"><i class="fa fa-weixin fa-lg"></i> 16</div>
            <div class="col-md-6 col-xs-6 well"><i class="fa fa-user-plus fa-lg"></i> Request</div>

        </div>
    </div>
</div>
</body>
</html>