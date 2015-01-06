<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1>${user.login}</h1>

<c:forEach items="${user.characters}" var="character">

	<h2>${character.name}</h2>
	<p>${character.charClass}</p>
	
	<table class="table table-bordered table-hover table-striped">
		<thead>
			<tr>
				<th>Chest piece</th>
				<th>Main hand</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${character.equip.chest}</td>
				<td>${character.equip.mainhand}</td>
			</tr>
		</tbody>
	</table>

</c:forEach>
