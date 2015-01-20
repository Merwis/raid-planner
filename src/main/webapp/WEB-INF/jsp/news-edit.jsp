<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<h1>Úprava novinky</h1>
<br /><br />

<form:form commandName="actualityEdit" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="header" class="col-sm-2 control-label">Nadpis:</label>
		<div class="col-sm-4">
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
			<input type="submit" value="Save" class="btn btn-lg btn-primary col-md-offset-10" />
		</div>
	</div>

</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".registrationForm").validate(
		{
			rules: {
				header: {
					required : true,
				},
				text: {
					required : true,
					maxlength : 255
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				header: {
					required: "Nadpis musí být vyplněn"
				},
				text: {
					required: "Text nesmí být prázdný",
					maxlength: "Text může mít maximálně 255 znaků"
				}
			}
		}		
	);
});
</script>



