<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
<center><h2>Find Flights</h2></center>

<form action="findFlights" method="post">
<pre>
Form : <input type="text" name="from"/>
To : <input type="text" name="to"/>
Departure Date : <input type=text name="departureDate"/>
<input type="submit" value="search"/>

</pre>
</form>


</body>
</html>