<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="${brouwer.naam}" />
</head>

<body>
	<v:menu />
	<h1>${brouwer.naam} (${brouwer.adres.gemeente})</h1>
	<ul class="naastElkaar">
		<c:forEach items='${bieren}' var='bier'>
			<c:url value='/bieren/bestellen' var="bestellenURL">
				<c:param name='bierId' value='${bier.id}'/>
			</c:url>
			<li class="opmaakLi"><a href="${bestellenURL}">${bier.naam}</a></li>
		</c:forEach>
	</ul>
</body>
</html>