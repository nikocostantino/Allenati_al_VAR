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
	<link rel="stylesheet" href="../css/home.css" type="text/css">
	<link rel="stylesheet" href="../css/pagina_video.css" type="text/css">
	<script type="text/javascript" src="../js/pagina_video.js"></script>
<meta charset="UTF-8">
<title>ALLENATI AL VAR - Pagina video</title>
</head>
<body>
	<%@include file="header_default.html" %>
	
	 <div class="jumbotron">
	 	<div class="row">
		 	<div class="column">
		 		<p id="categoria">Categoria: ${categoria} </p>
				<p id="difficolta"> ${difficolta} </p>
				<br>
				
				<iframe class="embed-responsive-item" src="${url}"></iframe>
				<div id="dati_video">
					<h1> ${nome} </h1>
					<p> ${descrizione}</p>
					<p> ${visualizzazioni}</p>
					<a class="badge badge-secondary" id="addPreferiti" href="pagina_video?url=${url}&&addPreferiti=${azione}" onclick="changeText()">Preferiti</a>
								
				</div>
			</div>
		
			<div class="column" id="lista_commenti" align="center">
				<c:forEach items="${lista_commenti}" var="c">
		                            	                            	
					<p> ${c} </p>
					
				</c:forEach>
			
				<form id="form_commenti" action="pagina_video?url=${url}" method="GET" class="form-group">
					<textarea class="form-control" id="textCommento" type="text " name="commento" placeholder="Scrivi un commento..."></textarea>
					<input class="form-control" type="submit" value="Invia"/></form>
				</form>
			
			<p class="btn btn-light" id="rispostaCorretta"> ${rispostaCorretta} </p>
			<p class="btn btn-light" id="rispostaErrata"> ${rispostaErrata} </p>	
			</div>
			
	</div>	
	</div>
	
	
</body>
</html>