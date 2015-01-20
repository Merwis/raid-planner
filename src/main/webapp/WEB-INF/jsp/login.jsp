<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../layout/taglib.jsp" %>
    

	  <form class="form-signin" action='<spring:url value="/j_spring_security_check" />' method="post">
        <h2 class="form-signin-heading">Přihlášení</h2>
        <label for="inputLogin" class="sr-only">Login</label>
        <input type="text" name="j_username" id="inputLogin" class="form-control" placeholder="Login" required autofocus>
        <label for="inputPassword" class="sr-only">Heslo</label>
        <input type="password" name="j_password" id="inputPassword" class="form-control" placeholder="Password" required>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Přihlásit</button>
      </form>
