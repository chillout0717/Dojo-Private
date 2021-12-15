<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>Create Dojo</h1>
	<form:form mathod="POST" action="/dojo/createDojo" modelAttribute="dojo">
		<p>
			<form:label path="name">Name </form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<button>Create Dojo</button>
	</form:form>

</body>
</html>