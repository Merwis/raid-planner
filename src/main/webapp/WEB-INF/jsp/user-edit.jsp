<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${user.login}" /></h1>

<h2>Úprava osobních informací</h2>

<form:form commandName="updateUser" cssClass="form-horizontal userEditForm">

	<div class="form-group">
		<label for="email" class="col-sm-2 control-label">E-mail:</label>
		<div class="col-sm-4">
			<form:input path="email" cssClass="form-control" value="${user.email}" />
			<form:errors path="email" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="name" class="col-sm-2 control-label">Jméno:</label>
		<div class="col-sm-3">
			<form:input path="name" cssClass="form-control" value="${user.name}" />
			<form:errors path="name" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-2 col-md-offset-2">
			<input type="submit" value="Uložit" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>

<h2>Změna hesla</h2>

<c:if test="${failed eq true }">
	<div class="alert alert-danger">Špatně zadané původní heslo.</div>
</c:if>
<c:if test="${failed eq false }">
	<div class="alert alert-danger">Špatně zadané nové heslo.</div>
</c:if>

<form:form action="password/${user.id}.html" commandName="updateUserPassword" cssClass="form-horizontal userEditPasswordForm">

	<div class="form-group">
		<label for="oldpassword" class="col-sm-2 control-label">Staré heslo:</label>
		<div class="col-sm-3">
			<input type="password" name="oldpassword" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Heslo:</label>
		<div class="col-sm-3">
			<form:password path="password" cssClass="form-control" />
			<form:errors path="password" />
		</div>
	</div>
	<div class="form-group">
		<label for="password" class="col-sm-2 control-label">Heslo znovu:</label>
		<div class="col-sm-3">
			<input type="password" name="password_again" id="password_again" class="form-control" />
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-2 col-md-offset-2">
			<input type="submit" value="Uložit" class="btn btn-lg btn-primary" />
		</div>
	</div>

</form:form>

<script type="text/javascript">
$(document).ready(function() {
	$(".userEditForm").validate(
		{
			rules: {
				email: {
					required : true,
					email : true
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				email: {
					required: "E-mail musí být vyplněn",
					email: "Vyplňte platný e-mail"
				}
			}
		}		
	);
	$(".userEditPasswordForm").validate(
			{
				rules: {
					password: {
						minlength : 5,
						required : true
					},
					password_again: {
						equalTo: "#password",
						required : true
					}
				},
				highlight: function(element) {
					$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
				},
				unhighlight: function(element) {
					$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
				},
				messages: {
					password: {
						minlength: "Heslo musí obsahovat alespoň 5 znaků",
						required: "Heslo nesmí být prázdné"
					},
					password_again: {
						equalTo: "Neodpovídá původnímu heslu",
						required: "Kotrola hesla nesmí být prázdná"
					}
				}
			}		
		);
});
</script>


