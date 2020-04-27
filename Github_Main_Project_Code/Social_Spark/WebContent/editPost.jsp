<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>this is a test</h1>
<form action="UpdatePost" method="post"> 
<textarea rows="5" cols="30" name="updateoption">${content}</textarea>
<input type="text" value="${id}" name ="id">
<input type="submit" value="submit"><br/> 
</form>
</body>
</html>