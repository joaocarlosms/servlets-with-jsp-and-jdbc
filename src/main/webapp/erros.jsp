<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Mensagem de erro, Por favor entre em contato com a equipe de suporte!</h1>
	
	<% 
		out.print(request.getAttribute("msg")); 
	%>

</body>
</html>