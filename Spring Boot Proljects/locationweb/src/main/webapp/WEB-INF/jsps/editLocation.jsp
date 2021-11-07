<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Customer Location Services</title>
</head>
<body>
	<form action="updateloc" method="post">
	<pre>
		Id: <input type="text" name="id"  value="${location.id}" readonly/> 
		Code:<input type="text" name="code" value="${location.code}" /> 
		Name:<input type="text" name="name" value="${location.name}"/> 
		Type: Urban<input type="radio" name="type" value="urban" ${location.type=='urban'?'checked':''}/>
		Rural<input type="radio" name="type" value="rural" ${location.type=='rural'?'checked':''}/> 
		<input type="submit" value="Save">
		</pre>
	</form>
</body>
</html>