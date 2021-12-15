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
	<form:form mathod="POST" action="/ninja/createNinja" modelAttribute="ninja">
		<p>
			<form:label path="dojo">Name : </form:label>
			<form:errors path="dojo"/>
			<form:select path="dojo">
				<c:forEach items="${allDojo}" var="dojo">
				<option value="${dojo.id}">${dojo.name}</option>
				</c:forEach>
			</form:select>
		</p>
		<p>
			<form:label path="firstName">FirstName : </form:label>
			<form:errors path="firstName"/>
			<form:input path="firstName"/>
		</p>
		
		<p>
			<form:label path="lastName">LastName : </form:label>
			<form:errors path="lastName"/>
			<form:input path="lastName"/>
		</p>
		
		<p>
			<form:label path="age">Age : </form:label>
			<form:errors path="age"/>
			<form:input path="age"/>
		</p>
		<button>create Ninja</button>
	</form:form>


</body>
</html>