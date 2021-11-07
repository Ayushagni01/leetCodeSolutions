package com.location.web.flight.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.web.flight.dto.ReservationRequest;
import com.location.web.flight.entities.Flight;
import com.location.web.flight.entities.Reservation;
import com.location.web.flight.repos.FlightRepository;
import com.location.web.flight.services.ReservationService;

@Controller
public class ReservationController {

	@Autowired
	FlightRepository fr;
	
	@Autowired
	ReservationService rs;
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(ReservationController.class);

	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("flightId") Long flightId,ModelMap mmap)
	{
		LOGGER.info("Inside showCompleteReservation() with flightid"+flightId);
	Flight flight = fr.findById(flightId).orElse(null);
		
	mmap.addAttribute("flight", flight);	
	LOGGER.info("Flight is "+flight);
	return "completeReservation";		
	}
	
	
	@RequestMapping(value="/completeReservation", method = RequestMethod.POST)
	public String completeReservation(ReservationRequest request,ModelMap mmap)
	{
		LOGGER.info("In completeReservation  "+request);
		
		Reservation reservation = rs.bookFlight(request);
		mmap.addAttribute("msg", "Reservation Created Successfully and the id is "+reservation.getId());
		return "reservationConfirmations";
		
	}
	
	
	
}
