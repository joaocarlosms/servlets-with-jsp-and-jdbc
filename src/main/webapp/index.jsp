<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Test JSP</title>
</head>
<body>

	<h1>Enviar dados</h1>
	<form action="ServletLogin" method="post">
		<input name="name">
		<input name="age">
		<input type="submit" value="Enviar"> 
	</form>
	
</body>
</html>