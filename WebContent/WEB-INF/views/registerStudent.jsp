<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register student</title>
</head>
<body>
	<spring:url value="/register" var="formUrl" />
	<sf:form modelAttribute="student" method="POST" action="${formUrl}">
		Username:<sf:input path="username" class="control" id="username"
			name="username" type="text" />
		<br>
		<sf:errors path="username"></sf:errors>
		<br>
		Password:<sf:input path="password" class="control" name="password"
			type="text" />
		<br>
		<sf:errors path="password"></sf:errors>
		<br>
		First name:<sf:input path="firstName" class="control" name="firstName"
			type="text" />
		<sf:errors path="firstName"></sf:errors>
		<br>
		Last name:<sf:input path="lastName" class="control" name="lastName"
			type="text" />
		<br>
		<sf:errors path="lastName"></sf:errors>
		<br>
		<button type="submit">Submit</button>


	</sf:form>

</body>
</html>