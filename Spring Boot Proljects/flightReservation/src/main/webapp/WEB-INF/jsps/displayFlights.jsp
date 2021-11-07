<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<title>Result Flights</title>
</head>
<body>
<h2>Flights</h2>
<table border="1">
<tr>
<th>Flight Number</th>
<th>Airlines</th>
<th>Departure City</th>
<th>Apprival City</th>
<th>Departure Date</th>
<th>Departure Time</th>
</tr>
<c:forEach  items="${flights}" var="flight" >
<tr>
<td>${flight.flightNumber}</td>
<td>${flight.operatingAirlines}</td>
<td>${flight.departureCity}</td>
<td>${flight.arrivalCity}</td>
<td>${flight.dateOfDeparture}</td>
<td>${flight.estimatedDepartureTime}</td>
<td><a href="showCompleteReservation?flightId=${flight.id}">Select</a> </td>

</tr>


</c:forEach>
</table>
</body>
</html>