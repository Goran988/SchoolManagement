<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<body>
	Wellcome to our School Management Site Please log in to start
	<br>
	<form action="login" method="POST">
		<br> <input type="text" class="form-control" name="username"
			placeholder="Username"> <br> <input type="password"
			class="form-control" name="password" placeholder="Password">
		<br> <label> <input type="checkbox" name="remember_me">
			Remember me
		</label> <input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit">Sign in</button>
		<button type="button"
			onclick="location.href='<spring:url value="/index"/>'">Home</button>
		<c:if test="${param.error==true}">
			<c:set value="colour alert alert-danger" var="msgdiv" />
			<c:set value="Error logging in." var="message" />
		</c:if>
	</form>
</body>
</html>