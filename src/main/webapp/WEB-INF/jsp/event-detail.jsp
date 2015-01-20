<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${event.eventTemplate.name}" /></h1>
<fmt:formatDate value="${event.date}" pattern="MM/dd/yyyy" var="stringDate" />
<fmt:formatDate value="${event.date}" type="time" timeStyle="short" var="stringTime" />


<table class="table table-bordered table-hover table-striped table-autowidth">
	<thead>

	</thead>
	<tbody>
			<tr>
				<td>
					Den	
				</td>
				<td>
					<fmt:formatDate value="${event.date}" pattern="dd. MM. yyyy" />	
				</td>
			</tr> 
			<tr>
				<td>
					Čas
				</td>
				<td>
					<fmt:formatDate value="${event.date}" type="time" timeStyle="short" />	
				</td>
			</tr>
	</tbody>
</table>

<security:authentication var="principal" property="principal" />
<c:if test="${principal.username == event.leader.login}">

 <script>
$(function() {
$( "#datepicker" ).datepicker();
});
$(function() {
$("#timepicker").timepicker({ 'timeFormat': 'H:i', 'step': 15, 'scrollDefault': 'now'  });
});

</script>

<form:form commandName="eventUpdate" cssClass="form-horizontal registrationForm">

	<c:if test="${failed eq true }">
		<div class="alert alert-danger">Neplatné datum! Doporučujeme zapnout javascript.</div>
	</c:if>

	<div class="form-group">
		<label for="date" class="col-sm-2 control-label">Datum:</label>
		<div class="col-sm-3">
			<form:input path="date" cssClass="form-control" id="datepicker" value="${stringDate}"/>
			<form:errors path="date" />
		</div>
	</div>
	<div class="form-group">
		<label for="time" class="col-sm-2 control-label">Čas:</label>
		<div class="col-sm-3">
			<form:input path="time" cssClass="form-control" id="timepicker" value="${stringTime}" />
			<form:errors path="time" />
		</div>
	</div>
	<div class="form-group">
		<label for="eventTemplate" class="col-sm-2 control-label">Šablona:</label>
		<div class="col-sm-3">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="eventTemplate" cssClass="form-control" >
				<c:forEach items="${et}" var="et">
				<form:option value="${et.id}" label="${et.name}" />
				</c:forEach>
			</form:select>
			<form:errors path="eventTemplate" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-2 col-md-offset-2">
			<input type="submit" value="Aktualizovat" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>
</c:if>


<table class="table table-bordered table-hover table-striped table-autowidth">
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
			<tr>
				<td>
					Leader:
				</td>
				<td>
					<c:out value="${event.leader.login}" />	
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
			<td><c:forEach items="${coeC}" var="coeC">
					<c:if test="${coeC.role == 'Tank'}">
						<a href='<spring:url value="/character/${coeC.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeC.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeC}" var="coeC">
					<c:if test="${coeC.role == 'Healer'}">
						<a href='<spring:url value="/character/${coeC.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeC.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeC}" var="coeC">
					<c:if test="${coeC.role == 'MDPS'}">
						<a href='<spring:url value="/character/${coeC.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeC.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeC}" var="coeC">
					<c:if test="${coeC.role == 'RDPS'}">
						<a href='<spring:url value="/character/${coeC.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeC.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
		</tr>
		<tr>
			<td>Přítomen</td>
			<td><c:forEach items="${coeA}" var="coeA">
					<c:if test="${coeA.role == 'Tank'}">
						<a href='<spring:url value="/character/${coeA.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeA.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeA}" var="coeA">
					<c:if test="${coeA.role == 'Healer'}">
						<a href='<spring:url value="/character/${coeA.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeA.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeA}" var="coeA">
					<c:if test="${coeA.role == 'MDPS'}">
						<a href='<spring:url value="/character/${coeA.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeA.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeA}" var="coeA">
					<c:if test="${coeA.role == 'RDPS'}">
						<a href='<spring:url value="/character/${coeA.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeA.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
		</tr>
		<tr>
			<td>Nepřítomen</td>
			<td><c:forEach items="${coeN}" var="coeN">
					<c:if test="${coeN.role == 'Tank'}">
						<a href='<spring:url value="/character/${coeN.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeN.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeN}" var="coeN">
					<c:if test="${coeN.role == 'Healer'}">
						<a href='<spring:url value="/character/${coeN.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeN.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeN}" var="coeN">
					<c:if test="${coeN.role == 'MDPS'}">
						<a href='<spring:url value="/character/${coeN.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeN.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
			<td><c:forEach items="${coeN}" var="coeN">
					<c:if test="${coeN.role == 'RDPS'}">
						<a href='<spring:url value="/character/${coeN.myCharacter.id}.html"/>' class="btn" ><c:out value="${coeN.myCharacter.name}" /></a>
						<br />
					</c:if>
				</c:forEach></td>
		</tr>
	</tbody>
</table>

<h2>Výběr postavy</h2>

<c:choose>
<c:when test="${characters != null }">
<form:form action="${event.id}/characters.html" commandName="characterAvailability" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="event" class="col-sm-2 control-label"></label>
		<div class="col-sm-3">
			<form:input type="hidden" path="event" value="${event.id}" cssClass="form-control"/>
			<form:errors path="event" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="myCharacter" class="col-sm-2 control-label">Postava:</label>
		<div class="col-sm-3">
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
		<div class="col-sm-3">
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
		<div class="col-sm-3">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="status" cssClass="form-control" >
				<form:option value="available" label="Přítomen" />
				<form:option value="notavailable" label="Nepřítomen" />
			</form:select>
			<form:errors path="status" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-2 col-md-offset-2">
			<input type="submit" value="Uložit" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>
</c:when>
<c:otherwise>
<p>Pro přihlášení se k eventu musíte nejprve <a href='<spring:url value="/account.html" />'>vytvořit postavu</a>.</p>
</c:otherwise>

</c:choose>

<c:if test="${coeF != null }">
<h2>Potvrzení účastníků</h2>
<form:form action="${event.id}/confirmation.html" commandName="characterConfirmation" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="event" class="col-sm-2 control-label"></label>
		<div class="col-sm-3">
			<form:input type="hidden" path="event" value="${event.id}" cssClass="form-control"/>
			<form:errors path="event" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="myCharacter" class="col-sm-2 control-label">Postava:</label>
		<div class="col-sm-3">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="myCharacter" cssClass="form-control" >
				<c:forEach items="${coeF}" var="coeF">
				<form:option value="${coeF.myCharacter.id}" label="${coeF.myCharacter.name}" />
				</c:forEach>
			</form:select>
			<form:errors path="myCharacter" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="status" class="col-sm-2 control-label">Status:</label>
		<div class="col-sm-3">
			<%-- <form:input path="eventTemplate" cssClass="form-control"/> --%>
			<form:select path="status" cssClass="form-control" >
				<form:option value="available" label="Přítomen" />
				<form:option value="confirmed" label="Potvrzen" />
			</form:select>
			<form:errors path="status" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-2 col-md-offset-2">
			<input type="submit" value="Uložit" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>
</c:if>
















