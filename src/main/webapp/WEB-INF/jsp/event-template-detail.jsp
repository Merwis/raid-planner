<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${eventTemplate.name}" /></h1>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th colspan="2"><c:out value="${eventTemplate.note}" /></th>
		</tr>
	</thead>
	<tbody>
			<tr>
				<td>
					Min. level:	
				</td>
				<td>
					<c:out value="${eventTemplate.minLvl}" />	
				</td>
			</tr> 
			<tr>
				<td>
					Max. počet hráčů:
				</td>
				<td>
					<c:out value="${eventTemplate.maxPlayers}" />	
				</td>
			</tr>
	</tbody>
</table>



