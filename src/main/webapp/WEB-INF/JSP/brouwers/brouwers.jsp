<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Brouwers" />
</head>

<body>
	<v:menu />
	<h1>Brouwers</h1>
	<ul class="naastElkaar">
		<c:forEach items='${brouwers}' var='brouwer'>
			<c:url value='/brouwers' var="brouwerURL">
				<c:param name='brouwerId' value='${brouwer.id}'/>
			</c:url>
			<li class="opmaakLi"><a href="${brouwerURL}">${brouwer.naam} (${brouwer.adres.gemeente})</a></li>
		</c:forEach>
	</ul>
</body>
</html>