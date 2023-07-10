<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65"
	crossorigin="anonymous">

<title>Projeto JSP</title>
<style type="text/css">
form {
	position: absolute;
	top: 40%;
	left: 33%;
}

label {
	color: #f2f2f2;
}

h2 {
	position: absolute;
	color: #e7e7e7;
	top: 30%;
	left: 33%;
}

.msg {
	position: absolute;
	top: 80%;
	left: 33%;
	font-size: 20px;
	font-family: inherit;
	color: #f3969f;
	/* 	#df8f97 */
/* background-color: #4c4497; */
	border: #b6d4fe;

	/* color: red; */
}

body {
	background-color: #4E5180;
}
</style>
</head>
<body>
	<h2>Tela de Login Projeto JSP</h2>
	<form action="ServletLogin" method="Post"
		class="row g-3 needs-validation" novalidate>
		<input type="hidden" value=<%=request.getParameter("url")%> name="url">
		<div class="mb-3">
			<b><label class="form-label" for="Login">Login</label></b> <b><input
				class="form-control" name="Login" id="Login" type="text" required></b>
		</div>

		<div class="mb-3">
			<b><label class="form-label" for="Senha">Senha</label></b> <b><input
				class="form-control" name="Senha" id="Senha" type="Password"
				required></b>
		</div>
		<input type="submit" class="btn btn-primary" value="Acessar">
	</form>
	<h4 class="msg">${msg}</h4>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
		crossorigin="anonymous"></script>

	<script type="text/javascript">
	(() => {
		  'use strict'

		  // Fetch all the forms we want to apply custom Bootstrap validation styles to
		  const forms = document.querySelectorAll('.needs-validation')

		  // Loop over them and prevent submission
		  Array.from(forms).forEach(form => {
		    form.addEventListener('submit', event => {
		      if (!form.checkValidity()) {
		        event.preventDefault()
		        event.stopPropagation()
		      }

		      form.classList.add('was-validated')
		    }, false)
		  })
		})()
	
	</script>
</body>
</html>