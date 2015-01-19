<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<h1 class="col-md-offset-4">Registrace nového uživatele</h1>
<br />

<form:form commandName="user" cssClass="form-horizontal registrationForm">

<c:if test="${success eq true }">
	<div class="alert alert-success">Registrace proběhla úspěšně!</div>
</c:if>

	<div class="form-group">
		<label for="login" class="col-sm-2 control-label col-md-offset-3">Login:</label>
		<div class="col-sm-3">
			<form:input path="login" cssClass="form-control"/>
			<form:errors path="login" />
		</div>
	</div>
	<div class="form-group">
		<label for="email" class="col-sm-2 control-label col-md-offset-3">E-mail:</label>
		<div class="col-sm-3">
			<form:input path="email" cssClass="form-control"/>
			<form:errors path="email" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label col-md-offset-3">Password:</label>
		<div class="col-sm-3">
			<form:password path="password" cssClass="form-control"/>
			<form:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label col-md-offset-3">Password again:</label>
		<div class="col-sm-3">
			<input type="password" name="password_again" id="password_again" class="form-control" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2 col-md-offset-5">
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
					required : true,
					minlength : 5
				},
				password_again: {
					required : true,
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
					required: "Heslo musí být vyplněno"
				},
				password_again: {
					minlength: "Heslo musí obsahovat alespoň 5 znaků",
					required: "Heslo musí být vyplněno",
					equalTo: "Neodpovídá původnímu heslu"
				}
			}
		}		
	);
});
</script>
