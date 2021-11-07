<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Customer Location Services</title>
</head>
<body>
	<form action="saveLoc" method="post">
	<pre>
		Id: <input type="text" name="id" /> 
		Code:<input type="text" name="code" /> 
		Name:<input type="text" name="name"> 
		Type: Urban<input type="radio" name="type" value="urban" />
		Rural<input type="radio" name="type" value="rural"/> 
		<input type="submit" value="Save">
		</pre>
	</form>
	
	${msg}
	<a href="displayLocations">View all</a>
</body>
</html>