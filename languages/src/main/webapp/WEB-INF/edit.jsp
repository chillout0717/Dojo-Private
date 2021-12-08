<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${editLanguage.name}</title>
</head>
<body>

	<form  method="POST" action="/delete/${editLanguage.id}">
		    <input type="hidden" name="_method" value="delete">
		   	<button>Delete</button>  	
	</form>  
	
	<a href="/"><button>Dashboard</button></a>


	<form:form action="/edit/${editLanguage.id}" method="POST" modelAttribute="editLanguage">
		<p>
			<form:label path="name">Name </form:label>
			<form:errors path="name"/>
			<form:input path="name"/>
		</p>
		<p>	
			<form:label path="creator">Creator </form:label>
			<form:errors path="creator"/>
			<form:input path="creator"/>
		</p>
		<p>
			<form:label path="currentVersion">Version </form:label>
			<form:errors path="currentVersion"/>
			<form:input path="currentVersion"/>
		</p>
		<input type="hidden" name="_mehtod" value="put">
		<button>Submit</button>
	</form:form>

</body>
</html>