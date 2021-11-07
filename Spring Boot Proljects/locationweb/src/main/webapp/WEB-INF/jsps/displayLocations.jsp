<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Locations:</h2>

<table border="1">
<tr>
<th>Id</th>
<th>Code</th>
<th>Name</th>
<th>Type</th>
</tr>

<c:forEach items="${locations}" var="location">
<tr>
<td>${location.id}</td>
<td>${location.code}</td>
<td>${location.name}</td>
<td>${location.type}</td> 
<td><a href="deletelocation?id=${location.id}">Delete</a></td>
<td><a href="showUpdate?id=${location.id}">Edit</a></td>
</tr>
</c:forEach>
</table>
<a href="sc">Add Location</a>
</body>
</html>