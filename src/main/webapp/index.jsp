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
	<form action="/jsp-course/test/ServletLogin" method="post">
		<table>
			<tr>
				<td><label>Login</label></td>
				<td><input name="login" type="text"></td>
			</tr>
			
			<tr>
				<td><label>Password</label></td>
				<td><input name="password" type="password"></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="Enviar"></td>
			</tr>
		</table>
	</form>
	
	<h1>${msg}</h1>
	
</body>
</html>