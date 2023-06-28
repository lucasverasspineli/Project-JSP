<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Projeto JSP</title>
	</head>
	<body>
		<h1>Projeto JSP!</h1>
		<form action="ServletLogin" method="Post">
		<input type="hidden" value=<%= request.getParameter("url") %> name="url">
			<table>
				<tr>
					<td>
						<label>Login</label>
					</td>				
					<td>					
						<input name="Login" type="text">
					</td>
				</tr>
				
				<tr>
					<td>
						<label>Senha</label>
					</td>					
					<td>		
						<input name="Senha" type="Password">
					</td>
				</tr>
			
				<tr>
					<td>
					
					</td>			
					<td>
						<input type="submit" value="Enviar">
					</td>
				</tr>
				
			</table>
		
		</form>
			<h4>${msg}</h4>
	</body>
</html>