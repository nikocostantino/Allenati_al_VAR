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
	<link rel="stylesheet" href="../css/prova_autovalutazione.css" type="text/css">
	<script type="text/javascript" src="../js/prova_autovalutazione.js"></script>
	
	<script src="https://www.youtube.com/iframe_api" ></script >
	
	
	<meta charset="UTF-8">
	<!-- REFRESH PAGINA OGNI 3 SECONDI <meta http-equiv="refresh" content="3"/> -->
	<title>ALLENATI AL VAR - Prova Autovalutazione</title>

</head>

<body>

	<div class="jumbotron">
		<h1><span class="badge badge-dark">PROVA DI AUTOVALUTAZIONE</span></h1>
	</div>
	<div align="center" id="cornice" class="jumbotron" >

	<br>
	<br>
	<c:set var = "videoProva" scope = "session" value = "${videoProva}"/>
	
	<h1><img src="../img/timer.png" /><span class="badge badge-success" id="timer"></span></h1>
	<!--  <iframe id="video" class="embed-responsive-item" src="${videoProva[0].url += "?autoplay=1"}"></iframe> -->
	
	<c:if test="${videoProva[0].locale == true }">
		<iframe id="video" class="embed-responsive-item" src="${videoProva[0].url}"></iframe>
	</c:if>
	<c:if test="${videoProva[0].locale == false }">
		<div  id="video-placeholder"></div>
		<div id="controls"> </div>
	</c:if>
	<br>
	<br>
	<a class="btn btn-light" href="prova_autovalutazione?risposta=${videoProva[0].risposte.opzioneCorretta}" id="rispostaCorretta"> ${videoProva[0].risposte.opzioneCorretta} </a>
	<a class="btn btn-light" href="prova_autovalutazione?risposta=${videoProva[0].risposte.opzioneErrata}" id="rispostaErrata"> ${videoProva[0].risposte.opzioneErrata} </a>	

	
	
	</div>
	

	<script>
	
	var player;

	function onYouTubeIframeAPIReady() {
	    player = new YT.Player('video-placeholder', {
	    	autoplay: 1,
	        width: 600,
	        height: 400,
	        videoId: '${videoProva[0].id}',
	        playerVars: {
	            color: 'white',
	            playlist: 'taJ60kskkns,FG0fTKAqZ5g',
	            autoplay: 1
	        },
	        events: {
	            onReady: timer
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
	
	
	
	// Set the date we're counting down to
	function timer(){
		if(player.getDuration()!=null)
			var countDownDate = player.getDuration()*2+5;
		else
			var countDownDate = 100;
		// Update the count down every 1 second
		var x = setInterval(function() {
		
		  countDownDate = countDownDate - 1;
		    
		  // Output the result in an element with id="demo"
		  document.getElementById("timer").innerHTML = countDownDate;
		  if (countDownDate >=4 && countDownDate <= 7) {
			  document.getElementById("timer").className = "badge badge-warning";
		  }
		  
		  if (countDownDate <= 3) {
			  document.getElementById("timer").className = "badge badge-danger";
		  }
		  
		  
		  
		  // If the count down is over, write some text 
		  if (countDownDate <= 0) {
		    clearInterval(x);
		    location.href="prova_autovalutazione?risposta=${videoProva[0].risposte.opzioneErrata}";
		  }
		}, 1000);
	}
		
	</script>
	
	
</body>

</html>