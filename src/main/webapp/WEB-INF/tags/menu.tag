<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='security'
	uri='http://www.springframework.org/security/tags'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%>
<div>
	<ul class="wegPadding">
		<li><a href="<c:url value='/'/>">Home</a></li>
		<li><a href="<c:url value='/brouwers'/>">Brouwers</a></li>
		<li><a href="<c:url value='/winkelwagen'/>">Winkelwagen</a></li>
	</ul>
</div>