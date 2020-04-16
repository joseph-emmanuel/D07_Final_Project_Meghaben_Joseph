<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>

	<h1>Home</h1>
	
	
	<tag:forEach var="post" items="${allPosts}">
	
		<span>${post.getDate()}</span> <br>
		<span>${post.getContent()}</span> <br>
		<span>${post.getEmail()}</span> <br><br><br>
	
	
	</tag:forEach>
	

</body>
</html>