<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${event.eventTemplate.name}" /></h1>
<p><c:out value="${event.date}" /></p>
<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th colspan="2"><c:out value="${event.eventTemplate.note}" /></th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>
					Min. level:	
				</td>
				<td>
					<c:out value="${event.eventTemplate.minLvl}" />	
				</td>
			</tr> 
			<tr>
				<td>
					Max. počet hráčů:
				</td>
				<td>
					<c:out value="${event.eventTemplate.maxPlayers}" />	
				</td>
			</tr>
	</tbody>
</table>

<c:forEach items="${coe}" var="coe">
	<p><c:out value="${coe.myCharacter.name}" /> <br /> <c:out value="${coe.role}" /></p>
</c:forEach>


