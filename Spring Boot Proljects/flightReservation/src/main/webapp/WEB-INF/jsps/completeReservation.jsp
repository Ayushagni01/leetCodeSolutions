<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete reservation</title>
</head>
<body>


<center><h2>Complete Reservation</h2></center>

Airline :${flight.operatingAirlines}<br> 
Departure City :${flight.departureCity} <br>
Arrival :${flight.arrivalCity}


<form action="completeReservation"  method="post">
<pre>
<h2>Passenger Details</h2>
First Name :<input type="text" name="passengerFirstName"/>
Last Name :<input type="text" name="passengerlastName"/>
Email :<input type="text" name="email"/>
phone :<input type="text" name="phone"/>

<h2>Card Details</h2>
Name on the Card  : <input type="text" name="nameOnTheCard"/>
Card no: <input type="text" name="cardNumber"/>
Expiry date : <input type="text" name="expirationDate"/>
Secuity SSn   : <input type="text" name="SecurityCode"/>

<input type="hidden" name="flightId" value="${flight.id} "/>
<input type="submit" value="confirm">

</pre>
</form>

</body>
</html>