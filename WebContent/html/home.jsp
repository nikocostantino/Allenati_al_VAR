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

<!-- CATEGORIA I PIU' VISTI -->
<div class="jumbotron">
	
  	<p>PIU' VISTI</p>
	<!-- Carousel row -->
        <div class="row">
            <!-- Top content -->
			<div class="top-content">
			    <div class="container-fluid">
			        <div id="carousel-example" class="carousel slide" data-ride="carousel">
			            <div class="carousel-inner row w-100 mx-auto" role="listbox">
			            	<c:set var = "first" scope = "session" value = "${true}"/>
			            	<c:set var = "cont" scope = "request" value ="${0}" />
			            	<c:forEach items="${video}" var="v">
			            	
				            	<c:if test="${first == true}">
			                		<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3 active">
				                </c:if>
				                <c:if test="${first == false && cont % 5 == 0 }">
				                	<div class="carousel-item col-12 col-sm-6 col-md-4 col-lg-3">
				                </c:if>

								
								
								<div class="embed-responsive-item">
		                         
			                       	<c:if test="${v.locale==false}">
										<iframe  src="${v.url}" allowfullscreen></iframe>
									</c:if>
									<c:if test="${v.locale==true}">
										<video width="320" height="240" controls>
											<source src="${v.url}" type="video/mp4">
										</video>
									</c:if>
								</div>
								
								<a class="badge badge-secondary" id="textNomeVideo" href="pagina_video?url=${v.url}">${v.nome}</a>
								
							
							<c:set var = "cont" scope = "request" value ="${cont + 1}" />
							<c:set var = "first" scope = "session" value = "${false}"/>
							<c:if test="${cont % 5 == 0}">	
								</div>
							</c:if>
							</c:forEach>
							
						</div>	
						<a class="carousel-control-prev" href="#carousel-example" role="button" data-slide="prev">
			                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
			                <span class="sr-only">Previous</span>
			            </a>
			            <a class="carousel-control-next" href="#carousel-example" role="button" data-slide="next">
			                <span class="carousel-control-next-icon" aria-hidden="true"></span>
			                <span class="sr-only">Next</span>
			            </a>
		         	</div>	
			                
	            </div>
	            		<!--  -->
	            
	            
			            <!--  -->
	        </div>
	    </div>
</div>
<!-- FINE CATEGORIA I PIU' VISTI -->

         
</body>
</html>