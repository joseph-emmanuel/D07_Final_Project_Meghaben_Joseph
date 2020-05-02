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
<form action="AddFriend" method="post">
<fieldset>
<h4>Add Friends</h4>
    <select name="people">
        <tag:forEach items="${people}" var="people">
            <option value="${people}">${people}</option>
        </tag:forEach>
    </select>
     <input type="submit" value="Display" />
</fieldset>
</form>
<br>
<br>
<h2>${user.getFname()}<br></h2>
<h2>${user.getLname()}<br></h2>
<h2>${user.getEmail()}<br></h2>
<h2></h2>
<br><br>
<a href="Home">Home</a>
<br>
<a href="LogoutServlet">Logout</a>
<form action="CreatePost" method="post">
<textarea name="content"></textarea>
<input type="file" name="image">
<br>
<button type="submit">create</button>
<button type="reset">reset</button>
</form>
<br><br>
<form action="PostOperation" method="post">
	<tag:forEach var="post" items="${userPosts}">	
		<jsp:include page="./posts/post.jsp" >
    		<jsp:param name="content" value="${post.getContent()}"/>
   			<jsp:param name="date" value="${post.getDate()}"/>
			<jsp:param name="email" value="${post.getEmail()}"/>
			<jsp:param name="id" value="${post.id}"/>
		</jsp:include> 	
	</tag:forEach>
</form>	


</body>
</html>