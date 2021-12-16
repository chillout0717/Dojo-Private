<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Question</title>
</head>
<body>
	<form:form method="POST" action="/newQuestion" modelAttribute="question">
	
		<p>
		<form:label path="qtext">Question</form:label>
		<form:errors path="qtext"></form:errors>
		<form:textarea path="qtext"/>
		</p>
		
		<p>
		<form:label path="tagsFromFrontEnd">Tag</form:label>
		<form:errors path="tagsFromFrontEnd"></form:errors>
		<form:input path="tagsFromFrontEnd"/>
		</p>
	
		<button>Submit Question</button>
		
	</form:form>
</body>
</html>