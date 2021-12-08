<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Languages</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
			<td>Name</td>
			<td>Creator</td>
			<td>Version</td>
			<td>action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${getAllLanguages}" var="lang">
			<tr>
				<td><a href="/show/${lang.id}">${lang.name}</a></td>
				<td>${lang.creator}</td>
				<td>${lang.currentVersion}</td>
				<td><a href="/edit/${lang.id}"><button>Edit</button></a> 
					<form  method="POST" action="/delete/${lang.id}">
			  			  <input type="hidden" name="_method" value="delete">
			   			<button>Delete</button>  	
					</form>  
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<form:form action="/" method="POST" modelAttribute="language">
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
		<button>Submit</button>
	</form:form>

</body>
</html>