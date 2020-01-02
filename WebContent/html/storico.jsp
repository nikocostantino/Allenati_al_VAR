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
	<link rel="stylesheet" href="../css/esito.css" type="text/css">
	<script type="text/javascript" src="../js/home.js"></script>

	<meta charset="UTF-8">

	<title>ALLENATI AL VAR - Storico</title>
	
</head>

<body>

	<%@include file="header_default.html" %>
	
	<div class="jumbotron container" id="risposte">
	
		<h1><span class="badge badge-light">STORICO</span></h1>
		
		<ul class="list-group">
		
			<c:forEach items="${storico}" var="s">
				<c:if test="${s.risultato==true}">
					<li class="list-group-item list-group-item-success">
				</c:if>
				<c:if test="${s.risultato==false}">
					<li class="list-group-item list-group-item-danger">
				</c:if>
					<a href="esito?data=${s.data}">
						<div class="row">
						
							<div class="column">
								<p>${s.data}</p>
								<p>${s.risultato}</p>
							</div>	
							
						</div>
					</a>
				</li>
			</c:forEach>
		</ul>
	</div>

</body>
</html>