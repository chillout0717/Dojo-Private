<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Details</title>
</head>
<body>
	<h1><c:out value="${dojo.name}"/>Location Ninjas</h1>
	
	<table>
		<tr>
		<th>First Name</th>
		<th>Last name</th>
		<th>AGE</th>
		<tr>
		<c:forEach items="${dojo.ninjas}" var="ninja">
			<td><c:out value="${ninja.firstName}"/></td>
			<td><c:out value="${ninja.lastName}"/></td>
			<td><c:out value="${ninja.age}"/></td>
		</c:forEach>
		</tr>
	</table>
</body>
</html>