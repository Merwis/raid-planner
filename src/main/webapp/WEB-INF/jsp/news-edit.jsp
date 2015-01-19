<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<form:form commandName="actualityEdit" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="header" class="col-sm-2 control-label">Nadpis:</label>
		<div class="col-sm-10">
			<form:input path="header" cssClass="form-control" value="${actuality.header}"/>
			<form:errors path="header" />
		</div>
	</div>
	<div class="form-group">
		<label for="text" class="col-sm-2 control-label">Text:</label>
		<div class="col-sm-10">
			<form:input path="text" cssClass="form-control" value="${actuality.text}"/>
			<form:errors path="text" />
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



