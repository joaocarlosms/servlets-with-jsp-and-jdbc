<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Test JSP</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

<style type="text/css">
	form {
		position: absolute;
		top: 40%;
		left: 33%;
		right: 33%;
	}
	
	h1 {
		position: absolute;
		top: 30%;
		left: 33%;
		font-weight: bold;
	}
	
	.msg {
		position: absolute;
		top: 60%;
		left: 33%;
		color: red;
	}
	
	#btn-form {
		border-radius: 5px;
	    padding: 0.8em;
	    width: 150px;
	}
	
	#login {
		font-size: 30px;
	}
	
	#password {
		font-size: 30px;
	}
		
</style>

</head>
<body>

	<h1>Realizar Login</h1>
	
	<form class="row g-3 needs-validation" action="/jsp-course/test/ServletLogin" method="post" novalidate>
		
		<input type="hidden" value="<%= request.getParameter("url") %>" name="url">
		
		<div class="col-md-6">
		    <label id="login" for="inputEmail4" class="form-label">Login</label>
		    <input type="text" class="form-control" id="inputEmail4" name="login" required>
	  		<div class="invalid-feedback">
		      Obrigatório
		    </div>
	  		
	  	</div>
	  	
	  	<div class="col-md-6">
	    	<label id="password" for="inputPassword4" class="form-label">Senha</label>
	    	<input type="password" class="form-control" id="inputPassword4" name="password" required>
	    	<div class="invalid-feedback">
		      Obrigatório
		    </div>
	  	</div>
	  	
	  	<div class="col-12">
			<button id="btn-form" type="submit" class="btn btn-primary">Acessar</button>
		</div>
	  	
	</form>
	
	<h5 class="msg">${msg}</h5>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	
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





















