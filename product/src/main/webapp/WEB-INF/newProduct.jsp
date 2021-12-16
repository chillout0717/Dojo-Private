<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Product</title>
</head>
<body>
		<h1>Create Product</h1>
	<form action="/newProduct" method="POST">
		<p>
		<label for="name">Name</label>
		<input type="text" name="name">
		</p>
		<p>
		<label for="description">Description</label>
		<textarea name="description"></textarea>
		</p>
		<p>
		<label for="price">Price</label>
		<input type="number" name="price">
		</p>
		<button>Create Product</button>
	</form>
	

</body>
</html>