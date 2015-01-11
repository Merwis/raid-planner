<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1>${user.login}</h1>

<form:form commandName="updateUser" cssClass="form-horizontal userEditForm">

	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">E-mail:</label>
		<div class="col-sm-10">
			<form:input path="email" cssClass="form-control" value="${user.email}" />
			<form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Heslo:</label>
		<div class="col-sm-10">
			<form:password path="password" cssClass="form-control" />
			<%-- <form:errors path="password" /> --%>
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Heslo znovu:</label>
		<div class="col-sm-10">
			<input type="password" name="password_again" id="password_again" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Jméno:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control" value="${user.name}" />
			<form:errors path="name" />
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
				login: {
					required : true,
					minlength : 3,
					remote : {
						url: "<spring:url value='/register/available.html' />",
						type: "get",
						data: {
							login: function() {
								return $("#login").val();
							}
						}
					}
				},
				email: {
					required : true,
					email : true
				},
				password: {
					minlength : 5
				},
				password_again: {
					minlength : 5,
					equalTo: "#password"
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				login: {
					remote: "Uživatel s tímto loginem již existuje",
					minlength: "Login musí obsahovat alespoň 3 znaky",
					required: "Login musí být vyplněn"
				},
				email: {
					email: "Vyplňte platný e-mail",
					required: "E-mail musí být vyplněn"
				},
				password: {
					minlength: "Heslo musí obsahovat alespoň 5 znaků",
				},
				password_again: {
					minlength: "Heslo musí obsahovat alespoň 5 znaků",
					equalTo: "Neodpovídá původnímu heslu"
				}
			}
		}		
	);
});
</script>


