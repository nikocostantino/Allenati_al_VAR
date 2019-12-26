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
            <div class="col col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                <!-- Carousel -->
                <div id="carousel-visti" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-visti" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-visti" data-slide-to="1"></li>
                        <li data-target="#carousel-visti" data-slide-to="2"></li>
                    </ol>

                    
                    <a class="column" href="#carousel-visti" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <div class="content">
                    	<div class="carousel-inner">
	                        <div class="carousel-item active">
	                            
	                            <c:forEach items="${video}" var="v">
	                            	
	                            	
	                            	<a class="badge badge-secondary" id="textNomeVideo" href="pagina_video?url=${v.url}">${v.nome}</a>
									<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
								</c:forEach>
	                            
	                        </div>
 
                   		</div>
                    </div>
                    <a class="column" href="#carousel-visti" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    
                </div>
                <!-- End carousel -->
            </div>
        </div>
</div>
<!-- FINE CATEGORIA I PIU' VISTI -->

<!-- CATEGORIA HAI GUARDATO RECENTEMENTE -->
<div class="jumbotron">
	
  	<p>HAI GUARDATO RECENTEMENTE</p>
	<!-- Carousel row -->
        <div class="row">
            <div class="col col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                <!-- Carousel -->
                <div id="carousel-recenti" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-recenti" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-recenti" data-slide-to="1"></li>
                        <li data-target="#carousel-recenti" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                    </div>
                    
                    <a class="carousel-control-prev" href="#carousel-recenti" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-recenti" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    
                </div>
                <!-- End carousel -->
            </div>
        </div>
</div>
<!-- FINE CATEGORIA HAI GUARDATO RECENTEMENTE -->

<!-- CATEGORIA DOGSO -->
<div class="jumbotron">
	
  	<p>DOGSO</p>
	<!-- Carousel row -->
        <div class="row">
            <div class="col col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                <!-- Carousel -->
                <div id="carousel-dogso" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-dogso" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-dogso" data-slide-to="1"></li>
                        <li data-target="#carousel-dogso" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div>
                               <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                    </div>
                    
                    <a class="carousel-control-prev" href="#carousel-dogso" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-dogso" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    
                </div>
                <!-- End carousel -->
            </div>
        </div>
</div>
<!-- FINE CATEGORIA DOGSO -->

<!-- CATEGORIA FALLO DI MANO -->
<div class="jumbotron">
	
  	<p>FALLO DI MANO</p>
	<!-- Carousel row -->
        <div class="row">
            <div class="col col-md-10 offset-md-1 col-lg-8 offset-lg-2">
                <!-- Carousel -->
                <div id="carousel-fallo-di-mano" class="carousel slide">
                    <ol class="carousel-indicators">
                        <li data-target="#carousel-fallo-di-mano" data-slide-to="0" class="active"></li>
                        <li data-target="#carousel-fallo-di-mano" data-slide-to="1"></li>
                        <li data-target="#carousel-fallo-di-mano" data-slide-to="2"></li>
                    </ol>
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <div>
                               <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                        <div class="carousel-item">
                            <div>
                                <c:forEach items="${video}" var="v">
								<iframe class="embed-responsive-item" src="${v.url}" allowfullscreen></iframe>
							</c:forEach>
                            </div>
                        </div>
                    </div>
                    
                    <a class="carousel-control-prev" href="#carousel-fallo-di-mano" role="button" data-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#carousel-fallo-di-mano" role="button" data-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="sr-only">Next</span>
                    </a>
                    
                </div>
                <!-- End carousel -->
            </div>
        </div>
</div>
<!-- FINE CATEGORIA FALLO DI MANO -->
		
         
</body>
</html>