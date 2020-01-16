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
	
	<script src="https://www.youtube.com/iframe_api" ></script >
	
	<meta charset="UTF-8">
	<title>ALLENATI AL VAR - Pagina video</title>
</head>
<body>
	<%@include file="header_default.html" %>
	
	<div id="cornice" class="container">
	
				<c:if test="${link != null}">
						
						<div class="alert alert-success alert-dismissible fade show" role="alert">
						  <strong>Video aggiunto correttamente!</strong>
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
						  </button>
						</div>
		 		</c:if>
		 		
		 		<c:if test="${modificato != null}">
						
						<div class="alert alert-success alert-dismissible fade show" role="alert">
						  <strong>Video modificato correttamente!</strong>
						  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
						  </button>
						</div>
		 		</c:if>

	 	<div  class="row">
		 	<div id="colonnaSx" class="column col-sm-7">

		 		<p id="categoria"> Categoria: ${categoria} </p>
				<p id="difficolta"> ${difficolta} </p>
				<c:if test="${amministratore == true}">
					<div id="div_button_gestione" class="btn-group btn-group-toggle" data-toggle="buttons">
					  <a class="btn btn-primary" id="button_modifica" href="gestorePagine?pagina=modificaVideo&&url=${url}" type="submit" href="#">Modifica</a>
					  <a class="btn btn-danger" id="button_elimina" href="#" data-toggle="modal" data-target="#Eliminazione">Rimuovi</a>
					</div>
				</c:if>

				<div  id="video-placeholder"></div>
				<div id="controls"> </div>
				
				<div id="dati_video">
					<div id="nome_video"> ${nome} </div> 
					<p> ${descrizione}</p>
					<p> ${visualizzazioni} visualizzazioni</p>
					
					<c:set var = "isPreferito" scope = "session" value = "${isPreferito}"/>
					<c:if test="${isPreferito == false}">
						<a class="badge badge-secondary" id="addPreferiti" href="pagina_video?url=${url}&&addPreferiti=${azione}">Preferiti</a>
					</c:if>	
					<c:if test="${isPreferito == true}">
						<a class="badge badge-secondary" id="addPreferiti" href="pagina_video?url=${url}&&addPreferiti=${azione}">Rimuovi</a>
					</c:if>	
								
				</div>
			</div>
		
			<div align="right" id="colonnaDx" class="column col-sm-5">
			
				<div  id="lista_commenti" class="up" >
					<c:forEach items="${lista_commenti}" var="c">                 	                            	
						<p class="" id="commento"> ${c} </p>				
					</c:forEach>
				</div>
			
				<div  id="underPanel" class="down">
				
					<form id="form_commenti" action="pagina_video?url=${url}" method="GET" class="form-group">
						<textarea class="form-control" id="textCommento"  name="commento" placeholder="Scrivi un commento..."></textarea>
						<input class="form-control" type="submit" value="Invia"/>
					 </form>
				</div>
			
				<div align="center" id="risposte" class="three"> 
					
					<c:if test="${ordineRisposte==0}">
						<button class="btn btn-dark" id="rispostaCorretta"> ${rispostaCorretta} </button>
						<button class="btn btn-dark" id="rispostaErrata"> ${rispostaErrata} </button>
					</c:if>
					<c:if test="${ordineRisposte==1}">
						<button class="btn btn-dark" id="rispostaErrata"> ${rispostaErrata} </button>
						<button class="btn btn-dark" id="rispostaCorretta"> ${rispostaCorretta} </button>
					</c:if>
				</div>
		
			</div>	
		</div>	
	</div>
	
	<!-- INIZIO CUSTOM ALERT -->
<div class="modal fade" id="Eliminazione">
    <div class="modal-dialog modal-sm">
      <div class="modal-content">
      
        <!-- Modal Header -->
        <div class="modal-header">
          <h4 class="modal-title">Sei Sicuro?</h4>
          <button type="button" class="close" data-dismiss="modal">&times;</button>
        </div>
        
        <!-- Modal body -->
        <div class="modal-body">
          Vuoi eliminare davvero questo video?
        </div>
        
        <!-- Modal footer -->
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-dismiss="modal">Annulla</button>
          <a class="btn btn-secondary" href="gestoreVideo?eliminaVideo=${url}">Elimina</a>
        </div>
        
      </div>
    </div>
  </div>

<!-- FINE CUSTOM ALERT -->
	<script>
		var player;
	
		function onYouTubeIframeAPIReady() {
		    player = new YT.Player('video-placeholder', {
		        width: 600,
		        height: 400,
		        videoId: '${id}',
		        playerVars: {
		            color: 'white'
		        },
		        events: {
		            onReady: initialize
		        }
		    });
		}

		function initialize(){

		    // Update the controls on load
		    updateTimerDisplay();
		    updateProgressBar();

		    // Clear any old interval.
		    clearInterval(time_update_interval);

		    // Start interval to update elapsed time display and
		    // the elapsed part of the progress bar every second.
		    time_update_interval = setInterval(function () {
		        updateTimerDisplay();
		        updateProgressBar();
		    }, 1000);


		    $('#volume-input').val(Math.round(player.getVolume()));
		}
		
	</script>
	
	
	
</body>
</html>