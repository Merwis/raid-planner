<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1>${user.login}</h1>

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
<table class="table table-bordered table-hover table-striped table-autowidth">
	<thead>
		<tr>
			<th>
				Role uživatele
			</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${user.roles}" var="role">
			<tr>
				<td>
					<p>${role.name}</p>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<form:form action="${user.id}/editroles.html"
	cssClass="form-horizontal registrationForm">
	<div class="form-group">
		<label for="role" class="col-sm-2 control-label">Role:</label>
		<div class="col-sm-3">
			<select name="role" class="form-control">
				<option value="u">User</option>
				<option value="o" label="Officer">Officer</option>
				<option value="a" label="Admin">Admin</option>
			</select>
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-2 col-md-offset-2">
			<input type="submit" value="Uložit" class="btn btn-lg btn-primary" />
		</div>
	</div>
</form:form>
<br /><br />
<h2>Postavy</h2>
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
				</table>
				
				</p>

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

