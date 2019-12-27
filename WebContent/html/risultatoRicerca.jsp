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
	
	<LINK rel="stylesheet" href="../css/home.css" type="text/css">
	<script type="text/javascript" src="../js/home.js"></script>
<meta charset="UTF-8">
<title>ALLENATI AL VAR - Pagina di ricerca</title>
</head>
<body>
<%@include file="header_default.html" %>
<!-- RISULTATO RICERCA -->
<div class="jumbotron">
	
  	<h1>RISULTATO RICERCA: ${textRicerca}</h1>
	<!-- Carousel row -->
        <div class="row">
            <div class="col col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                <!-- Carousel -->
                <div id="carousel-visti" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-ricerca" data-slide-to="0" class="active"></li>
                        
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div>
                            <c:forEach items="${risultatoRicerca}" var="r">
                            	<!-- PERCHE' NON FUNZIONA????  <a class="badge badge-secondary" id="textNomeVideo" href="pagina_video?url=${r.url}">${r.nome}</a> -->
								<iframe class="embed-responsive-item" src="${r.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
 
                    </div>
                    
                    <a class="carousel-control-prev" href="#carousel-ricerca" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-ricerca" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    
                </div>
                <!-- End carousel -->
            </div>
        </div>
</div>
</body>
</html>