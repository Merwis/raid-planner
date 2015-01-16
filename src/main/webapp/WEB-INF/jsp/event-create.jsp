<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

 <script>
$(function() {
$( "#datepicker" ).datepicker();
});
$(function() {
$("#timepicker").timepicker({ 'timeFormat': 'H:i', 'step': 15, 'scrollDefault': 'now'  });
});

</script>

<form:form commandName="eventCreate" cssClass="form-horizontal registrationForm">

	<div class="form-group">
		<label for="date" class="col-sm-2 control-label">Datum:</label>
		<div class="col-sm-10">
			<form:input path="date" cssClass="form-control" id="datepicker"/>
			<form:errors path="date" />
		</div>
	</div>
	<div class="form-group">
		<label for="time" class="col-sm-2 control-label">Čas:</label>
		<div class="col-sm-10">
			<form:input path="time" cssClass="form-control" id="timepicker" />
			<form:errors path="time" />
		</div>
	</div>
	<div class="form-group">
		<label for="eventTemplate" class="col-sm-2 control-label">Šablona:</label>
		<div class="col-sm-10">
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
				date: {
					required : true,
					date : true
				},
				time: {
					required : true,
				},
				eventTemplate: {
					required : true,
				}
			},
			highlight: function(element) {
				$(element).closest('.form-group').removeClass('has-success').addClass('has-error');
			},
			unhighlight: function(element) {
				$(element).closest('.form-group').removeClass('has-error').addClass('has-success');
			},
			messages: {
				date: {
					required: "Datum musí být vyplněno",
					date: "Neplatné datum"
				},
				eventTemplate: {
					required: "Šablona musí být vyplněna"
				}
			}
		}		
	);
});
</script>
