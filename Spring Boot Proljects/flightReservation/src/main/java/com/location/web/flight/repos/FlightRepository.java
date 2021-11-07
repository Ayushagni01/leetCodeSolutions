package com.location.web.flight.repos;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.location.web.flight.entities.Flight;


public interface FlightRepository extends JpaRepository<Flight, Long>,CrudRepository<Flight, Long> {

	//@Query("from Flight where departureCity=:departureCity and dateOfDeparture=:dateOfDeparture and arrivalCity=:arrivalCity")
	//List<Flight> findFlights(@Param("departureCity")String from,@Param("dateOfDeparture")Date departureDate,@Param("arrivalCity") String to);

	@Query("from Flight where departureCity=:departureCity  and arrivalCity=:arrivalCity")
	List<Flight> findFlights(@Param("departureCity")String from,@Param("arrivalCity") String to);
	
	
}
