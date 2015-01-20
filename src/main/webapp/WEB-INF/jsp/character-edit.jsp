<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="../layout/taglib.jsp" %>


<h1><c:out value="${myCharacter.name}" /></h1>

				<form:form commandName="updateMyCharacter"
					class="form-horizontal characterFormUpdate">
					<div class="form-group">
						<label for="name" class="col-sm-2 control-label">Jméno:</label>
						<div class="col-sm-3">
							<form:input path="name" cssClass="form-control" value="${myCharacter.name}"  />
							<form:errors path="name" />
						</div>
					</div>
					<div class="form-group">
						<label for="charClass" class="col-sm-2 control-label">Povolání:</label>
						<div class="col-sm-3">
							<form:input path="charClass" cssClass="form-control" value="${myCharacter.charClass}"/>
							<form:errors path="charClass" />
						</div>
					</div>
					<div class="form-group">
						<label for="race" class="col-sm-2 control-label">Rasa:</label>
						<div class="col-sm-3">
							<form:input path="race" cssClass="form-control" value="${myCharacter.race}"/>
							<form:errors path="race" />
						</div>
					</div>
					<div class="form-group">
						<label for="level" class="col-sm-2 control-label">Level:</label>
						<div class="col-sm-1">
							<form:input path="level" cssClass="form-control" value="${myCharacter.level}"/>
							<form:errors path="level" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-2 col-md-offset-2">
							<input type="submit" value="Save" class="btn btn-lg btn-primary" />
						</div>
					</div>
				</form:form>


