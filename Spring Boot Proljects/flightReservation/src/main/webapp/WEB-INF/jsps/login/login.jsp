<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>

form{
	text-align:center;
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
<center><h2>Login</h2></center>

<form action="logined" method="post">
<pre>
Email:<input type="text" name="email"/>
Password:<input type="password" name="password" />
<input type="submit" value="login"/>
${msg}
</pre>
</form>


</body>
</html>