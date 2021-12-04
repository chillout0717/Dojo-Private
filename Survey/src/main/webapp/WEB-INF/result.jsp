<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body>	
		<h1><U>Submitted Info</U></h1>
		
		<p>Name: <c:out value="${name}"/></p>
		<p>Language:<c:out value="${location}"/></p>
		<p>Location: <c:out value="${language}"/></p>
		<p>Comment:<c:out value="${comment}"/></p>
</body>

</html>