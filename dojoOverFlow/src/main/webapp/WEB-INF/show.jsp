<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>${question.qtext}</h1>
	<p>
	<c:forEach items="${question.tags}" var="tag">
	${tag.subject}
	</c:forEach>
	</p>
	<hr>
	<h2>Answers</h2>
	<ul>
	<c:forEach items="${question.answers}" var="answer">
		<li>${answer.atext}</li>
	</c:forEach>
	</ul>
	<hr>
	<h3>Add An Answer</h3>
	<form:form method="POST" action="/addAnswer" modelAttribute="answer">
		<p>
			<form:label path="atext"></form:label>
			<form:errors path="atext"/>
			<form:input path="atext"/>
			<form:hidden path="question" value="${question.id}"/>
		</p>
		<button>Add Answer</button>
	</form:form>

</body>
</html>