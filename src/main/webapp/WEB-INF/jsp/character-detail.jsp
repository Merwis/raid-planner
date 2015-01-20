<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1>${myCharacter.name}</h1>

<div>				
				<table class="table table-bordered table-hover table-striped table-autowidth">
					<tr>
						<th>
							Povolání
						</th>
						<td>
							<c:out value="${myCharacter.charClass}" />
						</td>
					</tr>
					<tr>
						<th>
							Rasa
						</th>
						<td>
							<c:out value="${myCharacter.race}" />
						</td>
					</tr>
					<tr>
						<th>
							Level
						</th>
						<td>
							<c:out value="${myCharacter.level}" />
						</td>
					</tr>
				</table></p>

	<h3>Výbava</h3>
	
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Chest</th>
							<th>Head</th>
							<th>Legs</th>
							<th>Main hand</th>
							<th>Off hand</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${myCharacter.equip.chest}" /></td>
							<td><c:out value="${myCharacter.equip.head}" /></td>
							<td><c:out value="${myCharacter.equip.legs}" /></td>
							<td><c:out value="${myCharacter.equip.mainhand}" /></td>
							<td><c:out value="${myCharacter.equip.offhand}" /></td>
						</tr>
					</tbody>
				</table>
			</div>

