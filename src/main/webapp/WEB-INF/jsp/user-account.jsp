<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1>${user.login}</h1>

<!-- Button trigger modal -->
<button type="button" class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
  Nová postava
</button>

<form:form commandName="myCharacter" cssClass="form-horizontal characterForm">
<!-- Modal -->
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Nová postava</h4>
      </div>
      <div class="modal-body">
      
        <div class="form-group">
		<label for="name" class="col-sm-2 control-label">Name:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control"/>
			<form:errors path="name" />
		</div>
		</div>
		
		<div class="form-group">
		<label for="charClass" class="col-sm-2 control-label">Class:</label>
		<div class="col-sm-10">
			<form:input path="charClass" cssClass="form-control"/>
			<form:errors path="charClass" />
		</div>
		</div>
	
	
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        <input type="submit" class="btn btn-primary" value="Save" />
        <!-- <button type="button" class="btn btn-primary">Save changes</button> -->
      </div>
    </div>
  </div>
</div>
</form:form>

<br /><br />

<script type="text/javascript">
$(document).ready(function() {
	$('.nav-tabs a:first').tab('show') // Select first tab	
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
	$(".characterForm").validate(
			{
				rules: {
					name: {
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
					name: {
						required: "Jméno musí být vyplněno"
					}
				}
			}		
		);
});

</script>

<div role="tabpanel">

  <!-- Nav tabs -->
  <ul class="nav nav-tabs" role="tablist">
  	<c:forEach items="${user.characters}" var="character">
    	<li role="presentation"><a href="#character_${character.id}" aria-controls="profile" role="tab" data-toggle="tab"><c:out value="${character.name}" /></a></li>
	</c:forEach>
  </ul>

  <!-- Tab panes -->
  <div class="tab-content">
  	<c:forEach items="${user.characters}" var="character">
    	<div role="tabpanel" class="tab-pane" id="character_${character.id}">
				<h2><c:out value="${character.name}" /></h2>
				<p>
				<a href="<spring:url value="/character/remove/${character.id}.html" />" class="btn btn-danger triggerRemove">Odstranit</a>
				
				<c:out value="${character.charClass}" /></p>

				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Chest piece</th>
							<th>Main hand</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${character.equip.chest}" /></td>
							<td><c:out value="${character.equip.mainhand}" /></td>
						</tr>
					</tbody>
				</table>
			</div>
    </c:forEach>
  </div>

</div>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Odstranit postavu</h4>
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
