<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dados do formulário</title>
</head>
<body>

	<%
		String name = request.getParameter("name");
		out.println(name);
		
		String age = request.getParameter("age");
		out.println(age);
	%>

</body>
</html>