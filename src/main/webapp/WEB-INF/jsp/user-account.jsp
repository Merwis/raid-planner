<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${user.login}" /></h1>

<a href='<spring:url value="/user/edit/${user.id}.html"/>' class="btn btn-default">Upravit</a>

<br /><br />

<c:if test="${success eq true }">
	<div class="alert alert-success">Heslo bylo změněno.</div>
</c:if>

<br />

<p><c:out value="${user.name}" /></p>
<p><c:out value="${user.email}" /></p>

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
		<label for="name" class="col-sm-2 control-label">Jméno:</label>
		<div class="col-sm-10">
			<form:input path="name" cssClass="form-control"/>
			<form:errors path="name" />
		</div>
		</div>
		
		<div class="form-group">
		<label for="charClass" class="col-sm-2 control-label">Povolání:</label>
		<div class="col-sm-10">
			<form:input path="charClass" cssClass="form-control"/>
			<form:errors path="charClass" />
		</div>
		</div>
		
		<div class="form-group">
		<label for="race" class="col-sm-2 control-label">Rasa:</label>
		<div class="col-sm-10">
			<form:input path="race" cssClass="form-control"/>
			<form:errors path="race" />
		</div>
		</div>
		
		<div class="form-group">
		<label for="level" class="col-sm-2 control-label">Level:</label>
		<div class="col-sm-10">
			<form:input path="level" cssClass="form-control"/>
			<form:errors path="level" />
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
				<a href='<spring:url value="/character/${character.id}.html"/>' class="btn btn-default">Upravit</a>
				
				<table class="table table-bordered table-hover table-striped table-autowidth">
					<tr>
						<th>
							Povolání
						</th>
						<td>
							<c:out value="${character.charClass}" />
						</td>
					</tr>
					<tr>
						<th>
							Rasa
						</th>
						<td>
							<c:out value="${character.race}" />
						</td>
					</tr>
					<tr>
						<th>
							Level
						</th>
						<td>
							<c:out value="${character.level}" />
						</td>
					</tr>
				</table></p>

	<h3>Výbava</h3>
	
				<table class="table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>Chest</th>
							<th>Head</th>
							<th>Legs</th>
							<th>Main hand</th>
							<th>Off hand</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${character.equip.chest}" /></td>
							<td><c:out value="${character.equip.head}" /></td>
							<td><c:out value="${character.equip.legs}" /></td>
							<td><c:out value="${character.equip.mainhand}" /></td>
							<td><c:out value="${character.equip.offhand}" /></td>
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

