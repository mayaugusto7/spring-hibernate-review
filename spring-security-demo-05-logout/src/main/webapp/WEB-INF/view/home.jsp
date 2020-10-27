<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hello Spring Securty</title>

<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
</head>
<body>
	<h2>Hello World Company Home Page</h2>
	
	<hr>
	
	<p>
		Welcome Spring Security Module home page!
	</p>
	
	<form:form 
				action="${pageContext.request.contextPath}/logout" 
				method="POST">
	
		<div class="container-login100-form-btn m-t-17">
			<input class="login100-form-btn" type="submit" value="Logout" />
		</div>
	</form:form>
	
</body>
</html>