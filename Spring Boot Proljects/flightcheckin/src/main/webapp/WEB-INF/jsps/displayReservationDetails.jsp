<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ReservationDetails</title>
</head>
<body>

<h2>Flight Details:</h2>

operatingAirlines ${reservation.flight.operatingAirlines}<br/>
flightNumber ${reservation.flight.flightNumber}<br/>
departureCity ${reservation.flight.departureCity}<br/>
arrivalCity ${reservation.flight.arrivalCity}<br/>
operatingAirlines ${reservation.flight.operatingAirlines}<br/>
estimatedDepartureTime ${reservation.flight.estimatedDepartureTime}<br/>


<h2>Passenger Detail</h2>

<br/>
firstName ${reservation.passenger.firstName}<br/>
lastName ${reservation.passenger.lastName}<br/>
email ${reservation.passenger.email}<br/>
phone ${reservation.passenger.phone}<br/>


<form action="completeCheckIn" method="post">
Enter the number of Bags to Checkin:
<input type="text" name="numberOfBags"/>
<input type="hidden" value="${reservation.id}" name="reservationId"/>
<input type="submit" value="Check In">


</form>


</body>
</html>