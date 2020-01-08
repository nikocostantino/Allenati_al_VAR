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
	
	<link rel="stylesheet" href="../css/aggiungi_video.css" type="text/css">
	<script type="text/javascript" src="../js/home.js"></script>
	<meta charset="UTF-8">
	<title>ALLENATI AL VAR - Aggiungi Video</title>
</head>

<body>
	<%@include file="header_default.html" %>



<div class="jumbotron container">

  			<h1><span class="badge badge-light">AGGIUNGI VIDEO</span></h1>	
  			
  			<div class="row">
  			<div class="column left">
  			<form id="formContent" method="POST" action="gestoreVideo?aggiungiVideo=true">
	      	
	      	<div class="active">
	      		<input type="text" id="link" class="fadeIn second" name="link" placeholder="link"/>
	      		<a class="btn btn-primary" id="avanti" type="submit" href="#">Avanti</a>
	      	</div>
	      	
	      	<div class="inactive">
	      	<input type="text" id="nome" class="fadeIn second" name="nome" placeholder="nome"/>
								
				
				
			<div class="fadeIn second" id="categoria" >
				<select name="categoria" required>
					<option value="" disabled selected>categoria</option>
					<option value="rigore">rigore</option>
					<option value="rosso">rosso</option>
					<option value="giallo">giallo</option>
					<option value="fuorigioco">fuorigioco</option>					
					<option value="fallo di mano">fallo di mano</option>
				
				</select>
			</div>	
			<div class="fadeIn second" id="grado di difficoltà" >
				<select name="grado di difficoltà" required>
					<option value="" disabled selected>grado di difficoltà</option>
					<option value="normale">normale</option>
					<option value="difficile">difficile</option>
					<option value="facile">facile</option>						
				</select>
			</div>
			
			<input type="text" id="opzioneRispostaCorretta" class="fadeIn second" name="opzioneRispostaCorretta" placeholder="opzione di risposta corretta"/>
			<input type="text" id="opzioneRispostaErrata" class="fadeIn second" name="opzioneRispostaErrata" placeholder="opzione di risposta errata"/>
			
			
			<textarea class="fadeIn second" id="descrizione"  name="descrizione" placeholder="descrizione"></textarea>
			
					  
			<div class="btn-group-toggle" data-toggle="buttons">
				<a class="btn btn-secondary" id="Indietro" href="gestorePagine?pagina=aggiungiVideo" type="submit">Indietro</a>
				<a class="btn btn-danger" id="Annulla" href="home" type="submit">Annulla</a>
	      		<button class="btn btn-primary" id="Aggiungi" type="submit">Aggiungi</button>
			</div>
			</div>		
	      	
	    	</form>
	    </div>
	    <div id="anteprimaVideo" class="column right">

	    	</div>
			</div> 
	    	
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
	<script>
		$("document").ready(function(){
			$("#avanti").on('click',function(){
				var $temp= $(this).closest("#formContent");
							
				var url=document.getElementById("link").value;
				if(url=="")
				{
					alert("URL VIDEO VUOTO!");				
				}
				else
				{
					$temp.find(".inactive").removeClass("inactive");
					$temp.find("#avanti").addClass("inactive");
					$temp.find("#link").addClass("inactive");

					var frame = "<iframe width='448' id='video' src='' height='252' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>";
					document.getElementById("anteprimaVideo").innerHTML=frame;
				
					document.getElementById("video").setAttribute("src", url);
				}
				

			})
		})
	</script>
</body>
</html>