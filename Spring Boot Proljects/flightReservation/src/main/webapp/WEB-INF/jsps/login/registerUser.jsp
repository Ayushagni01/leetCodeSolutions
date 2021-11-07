<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<title>Register User</title>
<style>
form{
	 text-align: center;
}
input{
    background-repeat:repeat-x;
    border: 1px solid black;
    height:25px;
    width:125px;
    margin:5px;
}
</style>
</head>
<body>
<center><h2>User Registration</h2></center>

<form action="registerUser" method="post">
<pre>
First Name:<input type="text" name="firstName"/>
Last Name:<input type="text" name="lastName"/>
Email:<input type="text" name="email"/>
Password<input type="password" name="password"/>
Confirm Password<input type="password" name="confirmPassword">
<input type="submit" value="register"/>
</pre>
</form>


</body>
</html>