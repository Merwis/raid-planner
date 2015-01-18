<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${eventTemplate.name}" /></h1>

<p><c:out value="${eventTemplate.note}" /></p>

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


<form:form commandName="eventTemplateUpdate" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Název:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" value="${eventTemplate.name}"/>
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="minLvl" class="col-sm-2 control-label">Min. level:</label>
		<div class="col-sm-10">
			<form:input path="minLvl" cssClass="form-control" value="${eventTemplate.minLvl}"/>
			<form:errors path="minLvl" />
		</div>
	</div>
	<div class="form-group">
		<label for="maxPlayers" class="col-sm-2 control-label">Max. hráčů:</label>
		<div class="col-sm-10">
			<form:input path="maxPlayers" cssClass="form-control" value="${eventTemplate.maxPlayers}"/>
			<form:errors path="maxPlayers" />
		</div>
	</div>
	<div class="form-group">
		<label for="note" class="col-sm-2 control-label">Poznámka:</label>
		<div class="col-sm-10">
			<form:input path="note" cssClass="form-control" value="${eventTemplate.note}"/>
			<form:errors path="note" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".registrationForm").validate(
		{
			rules: {
				name: {
					required : true,
				},
				minLvl: {
					required : true,
					number : true
				},
				maxPlayers: {
					required : true,
					number : true
				},
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				name: {
					required: "Název musí být vyplněn"
				},
				minLvl: {
					number: "Vyplňte číslo",
					required: "Minimální level musí být vyplněn"
				},
				maxPlayers: {
					number: "Vyplňte číslo",
					required: "Maximální počet hráčů musí být vyplněn"
				},
			}
		}		
	);
});
</script>



