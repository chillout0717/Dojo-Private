<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create new Category</title>
</head>
<body>
	<h1>Create Category</h1>
	<form:form mathod="POST" action="/newCategory">
		<p>
			<label for="name">Name</label>
			<input type="text" name="category">
		</p>
		<button>Create Category</button>
	</form:form>
	
</body>
</html>