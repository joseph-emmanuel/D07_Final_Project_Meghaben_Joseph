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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Profile</h1>

<h2>${user.getFname()}<br></h2>
<h2>${user.getLname()}<br></h2>
<h2>${user.getEmail()}<br></h2>
<br><br>
	
	
	<a href="Home">Home</a>
<a href="LogoutServlet">Logout</a> |  
<form action="CreatePost" method="post">
<textarea name="content"></textarea>
<input type="file" name="image">
<button type="submit">create</button>
<button type="reset">reset</button>
</form>

</body>
</html>