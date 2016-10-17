<%@page contentType='text/html' pageEncoding='UTF-8' session='false'%>
<%@taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
<%@taglib prefix='v' uri='http://vdab.be/tags'%>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!doctype html>
<html lang='nl'>
<head>
<v:head title="Winkelwagen" />
</head>

<body>
	<v:menu />

	<h1>Winkelwagen</h1>

	<table>
		<thead>
			<tr>
				<th>Bier</th>
				<th>Prijs</th>
				<th>Aantal</th>
				<th>Te betalen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items='${mandje}' var='bestellijn'>
				<tr class="opmaakTr">
					<td>${bestellijn.bier.naam}</td>
					<td class="tekstRechts"><fmt:formatNumber value="${bestellijn.bier.prijs}" /></td>
					<td class="tekstRechts">${bestellijn.aantal}</td>
					<td class="tekstRechts"><fmt:formatNumber value="${bestellijn.bier.prijs * bestellijn.aantal}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<tr>
				<td class="tekstRechts" id="vetteTekst" colspan="4">Totaal: <fmt:formatNumber value="${totaalprijs}" /></td>
			</tr>
		</tfoot>
	</table>

	<form class="formFormatting" method='post' action='<c:url value='/winkelwagen'/>'>
		<span>${fout}</span>
		<h4>Naam</h4>
		<input type="text" name="naam" value="${param.naam}" required />
		<h4>Straat</h4>
		<input type="text" name="straat" value="${param.straat}" required />
		<h4>Huisnummer</h4>
		<input type="text" name="huisNr" value="${param.huisNr}" required />
		<h4>Postcode</h4>
		<input class="geenPijltjes" type="number" name="postcode" value="${param.postcode}" min="1000" max="9999" required />
		<h4>Gemeente</h4>
		<input id="marginOnder" type="text" name="gemeente" value="${param.gemeente}" required />
		<span>${foutMandje}</span>
		<input type='submit' value='Als bestelbon bevestigen'>
	</form>
</body>
</html>