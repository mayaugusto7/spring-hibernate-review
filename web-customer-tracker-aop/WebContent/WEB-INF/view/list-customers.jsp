<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

<!--  add a search box -->
    <form:form action="search" method="GET">
        Search customer: <input type="text" name="theSearchName" />
        
        <input type="submit" value="Search" class="add-button" />
    </form:form>
            
	<div id="container">
		<div id="content">
			
			<!--  add button -->
			
			<input 	type="button"  
					value="Add Customer" 
					onclick="window.location.href='showFormForAdd'; return false;"
					class="add-button"
			/>
			
			
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!--  loop for -->
				<c:forEach var="customer" items="${customers}">
					<!-- construct an "update" link with customer id -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<!-- construct an "update" link with customer id -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${customer.id}" />
					</c:url>
					
					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td>
							<!-- display update link -->
							<a href="${updateLink}">Update</a>
							| <a href="${deleteLink}"
							     onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>