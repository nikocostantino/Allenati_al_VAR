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
	
	<div id="cornice" class="jumbotron">
	 	<div  class="row">
		 	<div id="colonnaSx" class="column jumbotron">
		 		<p id="categoria">Categoria: ${categoria} </p>
				<p id="difficolta"> ${difficolta} </p>
				
				<div class="btn-group btn-group-toggle" data-toggle="buttons">
				  <a class="btn btn-primary" type="submit" href="#">Modifica</a>
				  <a class="btn btn-danger" type="submit" href="eliminaVideo?url=${url}">Elimina</a>
				</div>
				<br>
				
				<iframe class="embed-responsive-item" src="${url}"></iframe>
				<div id="dati_video">
					<h1> ${nome} </h1>
					<p> ${descrizione}</p>
					<p> ${visualizzazioni}</p>
					
					<c:set var = "isPreferito" scope = "session" value = "${isPreferito}"/>
					<c:if test="${isPreferito == false}">
						<a class="badge badge-secondary" id="addPreferiti" href="pagina_video?url=${url}&&addPreferiti=${azione}">Preferiti</a>
					</c:if>	
					<c:if test="${isPreferito == true}">
						<a class="badge badge-secondary" id="addPreferiti" href="pagina_video?url=${url}&&addPreferiti=${azione}">Rimuovi</a>
					</c:if>	
								
				</div>
			</div>
		
			<div align="center" id="colonnaDx" class="column jumbotron">
			
			<div id="lista_commenti" class="up" >
				<c:forEach items="${lista_commenti}" var="c">
		                            	                            	
					<p> ${c} </p>
					
				</c:forEach>
			</div>
			
			<div  id="underPanel" class="down">
			
				<form id="form_commenti" action="pagina_video?url=${url}" method="GET" class="form-group">
					<textarea class="form-control" id="textCommento"  name="commento" placeholder="Scrivi un commento..."></textarea>
					<input class="form-control" type="submit" value="Invia"/>
				 </form>
			</div>
			
			<div align="center" id="risposte" class="three"> 
			<button class="btn btn-light" id="rispostaCorretta"  > ${rispostaCorretta} </button>
			<button class="btn btn-light"  id="rispostaErrata" > ${rispostaErrata} </button>
			</div>
		
			</div>
			
			
	</div>	

	
	</div>
</body>
</html>