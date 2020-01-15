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
  			
  			
  			<form id="formContent">
	      	
	      	<div id="formLink">
	      		<input type="text" id="link" class="fadeIn second" name="link" placeholder="link"/>
	      		<div id="formatoErrato">
	      			
	      		</div>
	      		<button class="btn btn-primary" id="avanti" type="submit" onclick="controllaUrl()">Avanti</button>
	      	</div>
	      	
	      	<div class="inactive" id="formAggiungi">
	      	<input type="text" id="nome" class="fadeIn second" name="nome" placeholder="nome" required/>
				<div id="nomeErrato">
	      			
	      		</div>				
				
				
			<div class="fadeIn second" id="categoria" >
				<select id="cat" name="categoria" required>
					<option value="" disabled selected>categoria</option>
					<option value="rigore">rigore</option>
					<option value="rosso">rosso</option>
					<option value="giallo">giallo</option>
					<option value="fuorigioco">fuorigioco</option>					
					<option value="fallo di mano">fallo di mano</option>
				
				</select>
			</div>	
			<div id="controlloCategoria" class="inactive">
				  <div id="formatErrato" class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Seleziona una categoria!</strong></div>	
			
			</div>
			
			<div class="fadeIn second" id="grado di difficolt�" >
				<select id="sel" name="grado di difficolt�" required>
					<option value="" disabled selected>grado di difficolt�</option>
					<option value="normale">normale</option>
					<option value="difficile">difficile</option>
					<option value="facile">facile</option>						
				</select>
			</div>
			<div id="controlloDifficolta" class="inactive">
				  <div id="formatErrato" class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Seleziona un grado di difficolt&agrave;!</strong></div>	
			
			</div>
			
			<input type="text" id="opzioneRispostaCorretta" class="fadeIn second" name="opzioneRispostaCorretta" placeholder="opzione di risposta corretta" required/>
			<div id="controlloOpzioneUno" class="inactive">
	      			<div id="formatErrato" class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Inserisci l'opzione di risposta corretta!</strong></div>	
	      	</div>
	      	
			<input type="text" id="opzioneRispostaErrata" class="fadeIn second" name="opzioneRispostaErrata" placeholder="opzione di risposta errata" required/>
			<div id="controlloOpzioneDue" class="inactive">
	      			<div id="formatErrato" class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Inserisci l'opzione di risposta errata!</strong></div>	
	      	</div>
			
			<textarea class="fadeIn second" id="descrizione"  name="descrizione" placeholder="descrizione" ></textarea>
			<div id="controlloDescrizione" class="inactive">
	      			<div id="formatErrato" class='alert alert-danger alert-dismissible fade show' role='alert'><strong>Inserisci una descrizione per il video!</strong></div>	
	      	</div>
	      	<div id="controlloLunghezzaDescrizione" class="inactive">
	      			<div id="formatErrato" class='alert alert-danger alert-dismissible fade show' role='alert'><strong>La descrizione che hai inserito � troppo lunga!</strong></div>	
	      	</div>
					  
			<div class="btn-group-toggle" data-toggle="buttons">
				<a class="btn btn-secondary" id="Indietro" href="gestorePagine?pagina=aggiungiVideo" type="submit">Indietro</a>
				<a class="btn btn-danger" id="Annulla" href="home" type="submit">Annulla</a>
	      		<a class="btn btn-primary" id="Aggiungi" onclick="controllaCaratteristiche()" href="javascript:void(0)" type="submit">Aggiungi</a>
	      		
	      			      		

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
	
	
		function controllaUrl(){
			var url = $("#link").val();
			$.ajax({
				type: "GET",
				url: "gestoreVideo",
				data: {urlNuovo: url},
				success: function(info){
					if(info.match("urlCorretto"))
					{
						$("document").ready(function(){
									var $temp= $("form");
															
									$temp.find("#formAggiungi").removeClass("inactive");
									$temp.find("#avanti").addClass("inactive");
									$temp.find("#link").addClass("inactive");
									$temp.find("#formatoErrato").addClass("inactive");
									$("div#anteprimaVideo").removeClass("inactive");
									var frame = "<iframe width='448' id='video' src='' height='252' frameborder='0' allow='accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture' allowfullscreen></iframe>";
									document.getElementById("anteprimaVideo").innerHTML=frame;
									document.getElementById("video").setAttribute("src", url);	
						})
					}
					else
					{							
						var $temp= $("form");
						$temp.find("#formatoErrato").removeClass("inactive");
						$("#formatoErrato").html(info);
					}
				}
			});
		}
		
		function controllaCaratteristiche(){
			var url = $("#link").val();
			var $temp= $("form");
			var nome = $("#nome").val();
			var descrizione = $("#descrizione").val();
			var opzioneUno = $("#opzioneRispostaCorretta").val();
			var opzioneDue = $("#opzioneRispostaErrata").val();
			
			var selectorDifficolta = document.getElementById('sel');
		    var valueDifficolta = selectorDifficolta[selectorDifficolta.selectedIndex].value;
		    
		    var selectorCategoria = document.getElementById('cat');
		    var valueCategoria = selectorCategoria[selectorCategoria.selectedIndex].value;
    
		   	var lunghezzaDescrizione = descrizione.length;

			if(valueDifficolta=="")
			{
				$temp.find("#controlloDifficolta").removeClass("inactive");
			}
			else
			{
				$temp.find("#controlloDifficolta").addClass("inactive");

			}
			
			
			if(valueCategoria=="")
			{
				$temp.find("#controlloCategoria").removeClass("inactive");
			}
			else
			{
				$temp.find("#controlloCategoria").addClass("inactive");

			}

			if(descrizione == "")
			{
				$temp.find("#controlloDescrizione").removeClass("inactive");
				$temp.find("#controlloLunghezzaDescrizione").addClass("inactive");

			}
			else if(lunghezzaDescrizione>100)
			{
				$temp.find("#controlloLunghezzaDescrizione").removeClass("inactive");
				$temp.find("#controlloDescrizione").addClass("inactive");

			}
			else
			{
				$temp.find("#controlloDescrizione").addClass("inactive");
				$temp.find("#controlloLunghezzaDescrizione").addClass("inactive");

			}
			
			if(opzioneUno == "")
			{
				$temp.find("#controlloOpzioneUno").removeClass("inactive");
			}
			else
			{
				$temp.find("#controlloOpzioneUno").addClass("inactive");
			}
			
			if(opzioneDue == "")
			{
				$temp.find("#controlloOpzioneDue").removeClass("inactive");
			}
			else
			{
				$temp.find("#controlloOpzioneDue").addClass("inactive");
			}

			
			$.ajax({
				type: "GET",
				url: "gestoreVideo?link="+url+"&&nome="+nome+"&&desc="+descrizione+"&&diff="+valueDifficolta+"&&cat="+valueCategoria+"&&opC="+opzioneUno+"&&opE="+opzioneDue,
				data: {nomeNuovo: nome},
				success: function(info){
					$("document").ready(function(){
							if(info.match("tuttoAPosto"))
							{
								window.location.href="gestoreVideo?aggiungiVideo=true&&link="+url+"&&nome="+nome+"&&desc="+descrizione+"&&diff="+valueDifficolta+"&&cat="+valueCategoria+"&&opC="+opzioneUno+"&&opE="+opzioneDue;
							}
							else
							{
								var $temp= $("form");
								$temp.find("#nomeErrato").removeClass("inactive");
								$("#nomeErrato").html(info);
							}
						
					})
				}
			});
		}
		
		
	</script>
</body>
</html>