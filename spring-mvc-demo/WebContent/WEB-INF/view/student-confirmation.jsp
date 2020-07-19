<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Confirmation</title>
</head>
<body>

	The student is confirmed: ${student.firstName} ${student.lastName}
	
	<br><br>
	
	Country: ${student.country}

	<br><br>
	
	Favorite Language: ${student.favoriteLanguage}

	<br><br>
	
	Operating Systems: ${student.favoriteLanguage}

	<ul>
		<c:forEach var="temp" items="${student.operatingSystems}">
			<li>${temp}</li>	
		</c:forEach>
	</ul>

</body>
</html>