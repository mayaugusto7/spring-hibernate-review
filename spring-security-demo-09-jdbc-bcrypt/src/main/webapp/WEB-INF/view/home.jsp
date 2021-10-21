<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hello Spring Securty</title>

<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
<div class="container-fluid">
	<h2>Hello World Company Home Page</h2>

	<hr>

	<p>Welcome Spring Security Module home page!</p>

	<hr>

	<!-- display user name and role -->

	<p>
		User:
		<security:authentication property="principal.username" />
		<br>
		<br> Role(s):
		<security:authentication property="principal.authorities" />
	</p>
	
	<security:authorize access="hasRole('MANAGER')">
	<!-- Add a link point to /leaders ... this if for the managers -->
	
	<p>
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for Manager peeps)
	</p>
	
	</security:authorize>
	
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add a link point to /systems ... this if for the admins -->
	
	<p>
		<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
		(Only for Admin peeps)
	</p>

	</security:authorize>

	<hr>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<div class="container-login100-form-btn m-t-17">
			<input class="login100-form-btn" type="submit" value="Logout" />
		</div>
	</form:form>
</div>
</body>
</html>