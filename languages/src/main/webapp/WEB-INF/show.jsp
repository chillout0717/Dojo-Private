<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${getLanguage.name}</title>
</head>
<body>

	<a href="/"><button>DashBoard</button></a>
	
	<p><c:out value="${getLanguage.name}"/></p>
	<p><c:out value="${getLanguage.creator}"/></p>
	<p><c:out value="${getLanguage.currentVersion}"/></p>
	
	<p><a href="/edit/${getLanguage.id}">Edit</a></p>
	
	<form  method="POST" action="/delete/${getLanguage.id}">
		    <input type="hidden" name="_method" value="delete">
		   	<button>Delete</button>
	</form>
	
</body>
</html>