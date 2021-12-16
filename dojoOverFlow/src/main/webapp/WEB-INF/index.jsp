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
	<table>
		<tr>
		<th>Question</th>
		<th>Tags</th>
		</tr>
		
		<c:forEach items="${allQ}" var="q">
		<tr>
		<td><a href="/show/${q.id}">${q.qtext}</a></td>
		<td>
		<c:forEach items="${q.tags}" var="tagtext">
			<p>${tagtext.subject}</p>
		</c:forEach>
		</td>
		<td>
		</tr>
		</c:forEach>
	</table>

</body>
</html>