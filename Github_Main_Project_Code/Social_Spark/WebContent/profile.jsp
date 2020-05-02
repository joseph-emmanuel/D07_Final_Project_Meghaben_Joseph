<%@page import="model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %> 

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
<h2></h2>
<br><br>
	<tag:forEach var="post" items="${userPosts}">	
		<jsp:include page="./posts/post.jsp" >
    		<jsp:param name="content" value="${post.getContent()}"/>
   			<jsp:param name="date" value="${post.getDate()}"/>
			<jsp:param name="email" value="${post.getEmail()}"/>
			<jsp:param name="id" value="${post.getId()}"/>
		</jsp:include> 	
	</tag:forEach>
	
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