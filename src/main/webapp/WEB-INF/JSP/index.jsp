<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="BierHuis" />
</head>
	
<body>
<v:menu />
	<h1>Welkom in het huis van Belgische bieren</h1>
	
	<c:url value="/images/bierhuis.jpg" var="FotoBierhuis" />
	<img src="${FotoBierhuis}"
		alt="Welkom in het huis van Belgische bieren" />
		
	<p> We hebben momenteel ${aantalBieren} bieren.</p>
</body>
</html>