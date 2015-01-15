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

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Status</th>
			<th>Tank</th>
			<th>Healer</th>
			<th>Melee DPS</th>
			<th>Ranged DPS</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>Potvrzen</td>
			<td><c:forEach items="${coeC}" var="coeC"><c:if test="${coeC.role == 'Tank'}"><c:out value="${coeC.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeC}" var="coeC"><c:if test="${coeC.role == 'Healer'}"><c:out value="${coeC.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeC}" var="coeC"><c:if test="${coeC.role == 'MDPS'}"><c:out value="${coeC.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeC}" var="coeC"><c:if test="${coeC.role == 'RDPS'}"><c:out value="${coeC.myCharacter.name}" /><br /></c:if></c:forEach></td>
		</tr>
		<tr>
			<td>Přítomen</td>
			<td><c:forEach items="${coeA}" var="coeA"><c:if test="${coeA.role == 'Tank'}"><c:out value="${coeA.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeA}" var="coeA"><c:if test="${coeA.role == 'Healer'}"><c:out value="${coeA.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeA}" var="coeA"><c:if test="${coeA.role == 'MDPS'}"><c:out value="${coeA.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeA}" var="coeA"><c:if test="${coeA.role == 'RDPS'}"><c:out value="${coeA.myCharacter.name}" /><br /></c:if></c:forEach></td>
		</tr>
		<tr>
			<td>Nepřítomen</td>
			<td><c:forEach items="${coeN}" var="coeN"><c:if test="${coeN.role == 'Tank'}"><c:out value="${coeN.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeN}" var="coeN"><c:if test="${coeN.role == 'Healer'}"><c:out value="${coeN.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeN}" var="coeN"><c:if test="${coeN.role == 'MDPS'}"><c:out value="${coeN.myCharacter.name}" /><br /></c:if></c:forEach></td>
			<td><c:forEach items="${coeN}" var="coeN"><c:if test="${coeN.role == 'RDPS'}"><c:out value="${coeN.myCharacter.name}" /><br /></c:if></c:forEach></td>
		</tr>
	</tbody>
</table>

<form:form action="${event.id}/characters.html" commandName="characterAvailability" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="event" class="col-sm-2 control-label"></label>
		<div class="col-sm-10">
			<form:input type="hidden" path="event" value="${event.id}" cssClass="form-control"/>
			<form:errors path="event" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="myCharacter" class="col-sm-2 control-label">Postava:</label>
		<div class="col-sm-10">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="myCharacter" cssClass="form-control" >
				<c:forEach items="${characters}" var="character">
				<form:option value="${character.id}" label="${character.name}" />
				</c:forEach>
			</form:select>
			<form:errors path="myCharacter" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="role" class="col-sm-2 control-label">Role:</label>
		<div class="col-sm-10">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="role" cssClass="form-control" >
				<form:option value="Tank" label="Tank" />
				<form:option value="Healer" label="Healer" />
				<form:option value="MDPS" label="Melee DPS" />
				<form:option value="RDPS" label="Ranged DPS" />
			</form:select>
			<form:errors path="role" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="status" class="col-sm-2 control-label">Status:</label>
		<div class="col-sm-10">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="status" cssClass="form-control" >
				<form:option value="available" label="Přítomen" />
				<form:option value="notavailable" label="Nepřítomen" />
			</form:select>
			<form:errors path="status" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>

<%-- <c:forEach items="${coe}" var="coe">
<c:out value="${coe.myCharacter.name}" /><br />
<c:out value="${coe.status}" /><br />
<c:out value="${coe.role}" /><br />
</c:forEach>
------------------------------------------<br />
<c:forEach items="${coeA}" var="coeA">
<c:out value="${coeA.myCharacter.name}" /><br />
<c:out value="${coeA.status}" /><br />
<c:out value="${coeA.role}" /><br />
</c:forEach> --%>















