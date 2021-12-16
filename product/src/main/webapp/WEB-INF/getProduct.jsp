<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Product</title>
</head>
<body>
		<h1><c:out value="${product.name}"/></h1>
		<c:out value="${product.description}"/>
		<c:out value="${product.price}"/>
		
		<hr>
		<h2>Categories</h2>
		<ul>
			<c:forEach items="${product.categories}" var="cat">
				<li>${cat.name}</li>
			</c:forEach>
		</ul>
		
		<form method="POST" action="/addCatToProd/${product.id}">
		<select name="cats">
			<c:forEach items="${showProduct}" var="cat">
				<option value="${cat.id}">${cat.name}</option>
			</c:forEach>
		</select>
		<button>Add Category</button>
		</form>
		
</body>
</html>