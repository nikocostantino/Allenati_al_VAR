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
	<script type="text/javascript" src="../js/home.js"></script>
	

	
	<meta charset="UTF-8">
	<title>ALLENATI AL VAR - Home page</title>
</head>

<body>
<%@include file="header_default.html" %>

<div class="jumbotron">
	<h1><span class="badge badge-light">PIU' VISTI</span></h1>
	
	<!--Carousel Wrapper-->
	<div id="video-carousel-example" class="carousel slide carousel-fade" data-ride="carousel">
	  <!--Indicators-->
	  <ol class="carousel-indicators">
	    <li data-target="#video-carousel-example" data-slide-to="0" class="active"></li>
	    <li data-target="#video-carousel-example" data-slide-to="1"></li>
	    <li data-target="#video-carousel-example" data-slide-to="2"></li>
	  </ol>
	  <!--/.Indicators-->
	  
	  <!--Slides-->
	  <div class="carousel-inner" role="listbox" id="columnCenter">
	    
	    <c:set var = "first" scope = "session" value = "${true}"/>
	    <c:set var = "cont" scope = "request" value ="${0}" />
	    <c:forEach items="${video}" var="v">
       	
	    	<c:if test="${first == true && cont % 5 == 0}">
	        	<div class="carousel-item active">
	       	</c:if>
			<c:if test="${first == false && cont % 5 == 0 }">
				<div class="carousel-item">
			</c:if>
			<div class="inline" align="center">
				<div class=rowUp>
					<c:if test="${v.locale==false}">
						<iframe  src="${v.url}" class="video-fluid"></iframe>
					</c:if>
	
					<c:if test="${v.locale==true}">
						<video width="300px" height="150px" class="video-fluid" controls muted>
			       			<source src="${v.url}" type="video/mp4" />
			     		</video>
					</c:if>
				</div>
				<div class="rowDown">
					<a class="badge badge-secondary" id="textNomeVideo" href="pagina_video?url=${v.url}">${v.nome}</a> 
				</div>
			</div>
			<c:set var = "cont" scope = "request" value ="${cont + 1}" />
			<c:set var = "first" scope = "session" value = "${false}"/>
			<c:if test="${cont % 5 == 0}">	
				</div>
			</c:if>
		</c:forEach>
	  </div>
	  <!--/.Slides-->
	  
	  <!--Controls-->
	  
	  <a id="column" class="carousel-control-prev" href="#video-carousel-example" role="button" data-slide="prev">
	    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	    <span class="sr-only">Previous</span>
	  </a>
	  <a id="column" class="carousel-control-next" href="#video-carousel-example" role="button" data-slide="next">
	    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	    <span class="sr-only">Next</span>
	  </a>
	  <!--/.Controls-->
	</div>
	<!--Carousel Wrapper-->
</div>
      
</body>
</html>