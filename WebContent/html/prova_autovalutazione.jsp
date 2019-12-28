<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"> 
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="../css/prova_autovalutazione.css" type="text/css">
	<script type="text/javascript" src="../js/prova_autovalutazione.js"></script>
	<meta charset="UTF-8">
	<!-- REFRESH PAGINA OGNI 3 SECONDI <meta http-equiv="refresh" content="3"/> -->
	<title>ALLENATI AL VAR - Prova Autovalutazione</title>
	
</head>

<body>

	<h1 class="jumbotron">PROVA DI AUTOVALUTAZIONE</h1>
	
	<div class="row">
	
		<div class="column">
		
			<c:set var = "videoProva" scope = "session" value = "${videoProva}"/>
			<iframe id="video" class="embed-responsive-item" src="${videoProva[0].url}"></iframe>
			
		</div>
		
		<div class="column">
			
			<a class="btn btn-light" href="prova_autovalutazione?risposta=${videoProva[0].risposte.opzioneCorretta}" id="rispostaCorretta"> ${videoProva[0].risposte.opzioneCorretta} </a>
			<a class="btn btn-light" href="prova_autovalutazione?risposta=${videoProva[0].risposte.opzioneErrata}" id="rispostaErrata"> ${videoProva[0].risposte.opzioneErrata} </a>	
		
		</div>
	
	</div>

</body>

</html>