<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
    
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js" integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js" integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1" crossorigin="anonymous"></script>
<meta charset="ISO-8859-1">
<title>Home</title>
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
      <div class="row hidden-md-up">
		<tag:forEach var="post" items="${allPosts}">
		<div class="col-md-4">
		<div class="card" style="width: 18rem;">
		<div class="card-body">	
			<jsp:include page="./posts/allPosts.jsp" >
	    		<p class="card-text"><jsp:param name="content" value="${post.getContent()}"/></p>
	   			<label><jsp:param name="date" value="${post.getDate()}"/></label>
				<label><jsp:param name="email" value="${post.getEmail()}"/></label>
				<label><jsp:param name="id" value="${post.getId()}"/></label>
			</jsp:include> 
			</div>
			</div>
		</div>
		</tag:forEach>
	</div>
</div>
</body>
</html>
