<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../css/index.css" type="text/css">
	<script type="text/javascript" src="../js/index.js"></script>
	<meta charset="UTF-8">
	<title>ALLENATI AL VAR - Login page</title>
</head>

<body>

	<div class="wrapper fadeInDown">
	  	<div id="formContent">

		 	<div class="fadeIn first">
	      		<img src="../img/referee.png" id="icon" alt="User Icon" />
	    	</div>
	    	
	    	<form method="POST" action="login">
	      		<input type="text" id="email" class="fadeIn second" name="email" placeholder="email"/>
	      		<input type="password" id="password" class="fadeIn third" name="password" placeholder="password"/>
	      		<button class="btn btn-primary" type="submit">Login</button>
	      		<h1></h1>
	    	</form>
	
	    	<div id="formFooter">
	      		<a class="btn btn-secondary" type="submit" href="registrati">Registrati</a>
	    	</div>
		</div>
	</div>

</body>
</html>