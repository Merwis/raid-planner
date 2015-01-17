<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$(".triggerRemove").click(function(e) {
		e.preventDefault();
		$("#modalRemove .removeBtn").attr("href", $(this).attr("href"));
		$("#modalRemove").modal();
	});
});

</script>

<a href='<spring:url value="/event/create.html"/>' class="btn">Vytvořit event</a>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Datum</th>
			<th>Event</th>
			<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICER')">
			<th>Delete</th>
			</security:authorize>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${events}" var="event">
			<tr>
				<td>
					<a href='<spring:url value="/event/detail/${event.id}.html"/>'>
						<fmt:formatDate value="${event.date}" pattern="dd. MM. yyyy" /><br />
						<fmt:formatDate value="${event.date}" type="time" timeStyle="short" />
					</a>
				</td>
				<td>
					<a href='<spring:url value="/event/detail/${event.id}.html"/>'>
						<c:out value="${event.eventTemplate.name}" />
					</a>
				</td>
				<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_OFFICER')">
				<td>
					<a href="<spring:url value="/event/remove/${event.id}.html" />" class="btn btn-danger triggerRemove">Odstranit</a>
				</td>
				</security:authorize>
			</tr>
		</c:forEach>
	</tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="modalRemove" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" id="myModalLabel">Odstranit uživatele</h4>
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

