<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


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

<a href='<spring:url value="/event/template/create.html"/>' class="btn">Vytvořit novou šablonu</a>

<table class="table table-bordered table-hover table-striped">
	<thead>
		<tr>
			<th>Šablony eventů</th>
			<th>Delete</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${eventTemplate}" var="eventTemplate">
			<tr>
				<td>
					<a href='<spring:url value="/event/template/detail/${eventTemplate.id}.html"/>'>
						<c:out value="${eventTemplate.name}" />
					</a>
				</td>
				<td>
					<a href="<spring:url value="/event/template/remove/${eventTemplate.id}.html" />" class="btn btn-danger triggerRemove">Odstranit</a>
				</td>
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
        <h4 class="modal-title" id="myModalLabel">Odstranit šablonu eventu</h4>
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

