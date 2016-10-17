<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="${bier.naam}" />
</head>

<body class="formFormatting">
	<v:menu />

	<h1>${bier.naam}</h1>

	<h4>Alcohol</h4>
	<p>
		<fmt:formatNumber value="${bier.alcohol}" />
		%
	</p>

	<h4>Prijs</h4>
	<p>
		<fmt:formatNumber value="${bier.prijs}" />
		€
	</p>

	<h4>Soort</h4>
	<p>${bier.soort.naam}</p>

	<h4>Brouwer</h4>
	<p>${bier.brouwer.naam}</p>

	<h4>Aantal</h4>

	<c:url value='/bieren' var='toevoegenURL'>
		<c:param name='bierId' value='${bier.id}' />
	</c:url>
	<form method='post' action='${toevoegenURL}'>
		<span>${fout}</span> 
		<input type="number" name="aantal" min="1" step="1" autofocus required /> 
		<input type='submit' value='Toevoegen'>
	</form>
</body>
</html>