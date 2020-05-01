<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tag" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Social Spark</title>
</head>
<body>
	<h1>Social Spark</h1>

	<fieldset>
		<legend>Login</legend>
		<form action="Login" method="POST">
			<input type="email" name="email" placeholder="Enter your Email">
			<br><br>
			<input type="password" name="pass" placeholder="Enter your Password">
			<br><br>
			<button type="submit">Login</button>
			<button type="reset">Reset</button>
			<a href="register.jsp">register</a>
			<tag:if test="${loginError}">
					<br>
					<span> incorrect email or password </span>	
			</tag:if>			
		</form>
	</fieldset>
</body>
</html>