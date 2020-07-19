<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<meta charset="ISO-8859-1">
<title>Spring MVC Demo - Home Page</title>
	<!-- <link	rel="stylesheet" 
			type="text/css" 
		  	href="${pageContext.request.contextPath}/resources/css/my-test.css">
 -->
	
 	<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
<body>

	<h1>Spring MVC Demo - Home Page</h1>
	
	<a href="hello/showForm">Hello World form</a>
	
	<hr>

	<a href="student/showForm">Student form</a>

	<hr>

	<a href="customer/showForm">Customer form</a>

	<hr>
		
	<img width="100" height="100" src="${pageContext.request.contextPath}/resources/images/spring-logo.png" />
		
	<input class="btn btn-primary" type="button" onclick="doSomeWork()" value="Click Me"/>
	
</body>
</html>