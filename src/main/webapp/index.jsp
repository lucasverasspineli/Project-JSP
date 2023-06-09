<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Projeto JSP</title>
	</head>
	<body>
		<h1>Tela Inicial para testes!</h1>
		<form action="ServletLogin" method="Post">
		
			<label>Login</label>
			<input name="Login" type="text">
			<label>Senha</label> 
			<input name="Senha" type="Password">
			<input type="submit" value="Enviar">
		</form>
		
	</body>
</html>