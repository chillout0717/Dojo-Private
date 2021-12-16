<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Details</title>
</head>
<body>
	<h1><c:out value="${category.name}"/></h1>
	<hr>
	<h2>products</h2>
	<c:forEach items="${category.products}" var="prod">
	<li>${prod.name} | ${prod.description} | ${prod.price}
	</li>
	</c:forEach>
	
	<form method="POST" action="/addProdToCat/${category.id}">
	<select name="prod">
		<c:forEach items="${showCategory}" var="prod">
			<option value="${prod.id}"> ${prod.name}</option>
		</c:forEach>
	</select>
	<button>Add Category</button>
	</form>
</body>
</html>