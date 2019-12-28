<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ALLENATI AL VAR - Esito Prova</title>
</head>
<body>
<h1>ESITO PROVA</h1>
<a href="home.jsp">Torna alla home</a>
<div id="risposte">

	<c:forEach items="${risposteProva}" var="r">
		<p>${r}</p>
	</c:forEach>	
</div>
</body>
</html>