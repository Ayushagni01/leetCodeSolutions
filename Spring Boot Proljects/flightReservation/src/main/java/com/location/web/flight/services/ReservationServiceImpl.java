package com.location.web.flight.services;

import javax.transaction.Transactional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.location.web.flight.controller.ReservationController;
import com.location.web.flight.dto.ReservationRequest;
import com.location.web.flight.entities.Flight;
import com.location.web.flight.entities.Passenger;
import com.location.web.flight.entities.Reservation;
import com.location.web.flight.repos.FlightRepository;
import com.location.web.flight.repos.PassengerRepository;
import com.location.web.flight.repos.ReservationRepository;
import com.location.web.flight.util.EmailUtil;
import com.location.web.flight.util.PDFGenerator;

@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Value("${com.ayush.filedir}")
	private   String ITINERARY_DIR ;
	//= "C:/Users/ayush/Documents/Reservation/reservation";

	@Autowired
	FlightRepository  fr;
	
	@Autowired
	PassengerRepository pr;
	
	@Autowired
	ReservationRepository rr;
	
	@Autowired
	PDFGenerator pg;
	
	@Autowired
	EmailUtil eu;
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(ReservationServiceImpl.class);

	
	@Override
	@Transactional
	public Reservation bookFlight(ReservationRequest request) {
		
		//Make Payment
		LOGGER.info("In bookFlight()");
		Long flightId = request.getFlightId();
		LOGGER.info("Fetching Flights for flight id"+flightId);
		Flight flights = fr.findById(flightId).orElse(null);
		Passenger passenger=new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerlastName());
		passenger.setPhone(request.getPhone());
		passenger.setEmail(request.getEmail());
		LOGGER.info("saving passenger"+passenger);
		Passenger savedPassenger = pr.save(passenger);
		
		Reservation reservation=new Reservation();
		reservation.setFlight(flights);
		reservation.setPassenger(savedPassenger);
		reservation.setCheckedIn(false);
		LOGGER.info("saving Reservation"+reservation);
		Reservation savedReservation = rr.save(reservation);
		LOGGER.info("Generating the Iternary");
		String filepath =ITINERARY_DIR+savedReservation.getId()+".pdf";
		pg.generateItinerary(savedReservation, filepath);
		LOGGER.info("Emailing  the Iternary");
		eu.sendIternary(passenger.getEmail(), filepath);
		
		return savedReservation;
	}

}
