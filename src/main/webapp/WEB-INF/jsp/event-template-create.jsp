<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<h1>Tvorba nové šablony</h1>

<form:form commandName="eventTemplate" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Název:</label>
		<div class="col-sm-3">
			<form:input path="name" cssClass="form-control"/>
			<form:errors path="name" />
		</div>
	</div>
	<div class="form-group">
		<label for="minLvl" class="col-sm-2 control-label">Min. level:</label>
		<div class="col-sm-3">
			<form:input path="minLvl" cssClass="form-control"/>
			<form:errors path="minLvl" />
		</div>
	</div>
	<div class="form-group">
		<label for="maxPlayers" class="col-sm-2 control-label">Max. hráčů:</label>
		<div class="col-sm-3">
			<form:input path="maxPlayers" cssClass="form-control"/>
			<form:errors path="maxPlayers" />
		</div>
	</div>
	<div class="form-group">
		<label for="note" class="col-sm-2 control-label">Poznámka:</label>
		<div class="col-sm-5">
			<form:input path="note" cssClass="form-control"/>
			<form:errors path="note" />
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-2">
			<input type="submit" value="Save" class="btn btn-lg btn-primary col-md-offset-2" />
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
