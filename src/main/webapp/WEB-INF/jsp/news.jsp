<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>

<h1>GOOD NEWS EVERYONE!</h1>


<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICER')">
<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
Nová aktualita
</button>
</security:authorize>

<c:forEach items="${actualities}" var="actuality">
<h2>${actuality.header}</h2>
<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICER')">
<a class="btn btn-default" href='<spring:url value="news/edit/${actuality.id}.html" />'>Upravit</a>
<a href="<spring:url value="news/remove/${actuality.id}.html" />" class="btn btn-danger triggerRemove">Odstranit</a>
</security:authorize>
<p>
	Od: ${actuality.author.login} | dne: <fmt:formatDate value="${actuality.published}" dateStyle="short" />
	 v <fmt:formatDate value="${actuality.published}" type="time" timeStyle="short" /> hod.
	 <c:if test="${actuality.edited != null }"> 
	  | upraveno dne: <fmt:formatDate value="${actuality.edited}" dateStyle="short" />
	 v <fmt:formatDate value="${actuality.edited}" type="time" timeStyle="short" />	 
	 </c:if>
</p>
<p>${actuality.text}</p>
</c:forEach>

<form:form commandName="actualityAdd" cssClass="form-horizontal actualityForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Nová aktualita</h4>
      </div>
      <div class="modal-body">
      
        <div class="form-group">
		<label for="header" class="col-sm-2 control-label">Nadpis:</label>
		<div class="col-sm-10">
			<form:input path="header" cssClass="form-control"/>
			<form:errors path="header" />
		</div>
		</div>
		
		<div class="form-group">
		<label for="text" class="col-sm-2 control-label">Text:</label>
		<div class="col-sm-10">
			<form:textarea path="text" cssClass="form-control"/>
			<form:errors path="text" />
		</div>
		</div>
		
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Storno</button>
        <input type="submit" class="btn btn-primary" value="Uložit" />
        <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
      </div>
    </div>
  </div>
</div>
</form:form>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Odstranit aktualitu</h4>
      </div>
      <div class="modal-body">
        Opravdu chcete položku odstranit?
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Storno</button>
        <a href="" class="btn btn-danger removeBtn">Odstranit</a>
      </div>
    </div>
  </div>
</div>

<br /><br />

<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show') // Select first tab	
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
	$(".actualityForm").validate(
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