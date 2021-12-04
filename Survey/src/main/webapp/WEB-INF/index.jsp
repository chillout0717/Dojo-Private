<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body>
	<h1>Dojo Survey</h1>
	
	
	<form action="/result" method="post">
		<div class="formName">
			<label>Your Name</label>
			<input type="text" name="name" id="name"/>
		</div>
		
		<div class="formLocation">
			<label>Dojo Location</label>
			<select name="location" id="location">
				<option value="San Jose">San Jose</option>
				<option value="Diamond bar">Diamond bar</option>
				<option value="Los angeles">Los angeles</option>
			</select>
		</div>
		
		<div class="formLanguage">
			<label>Favorite Language</label>
			<select name="language" id="location">
				<option value="Python">Python</option>
				<option value="Java">Java</option>
				<option value="C#">C#</option>
			</select>
		</div>
		
		<div class="formComment">
			<label for="comment">Comment (optional) : </label>
			<textarea name="comment"></textarea>
		</div>
		
		<button class="button">Send</button>
	</form>
</body>