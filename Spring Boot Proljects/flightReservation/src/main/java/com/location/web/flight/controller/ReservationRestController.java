package com.location.web.flight.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.location.web.flight.dto.ReservationUpdateRequest;
import com.location.web.flight.entities.Reservation;
import com.location.web.flight.repos.ReservationRepository;
import com.location.web.flight.util.PDFGenerator;

@RestController
@CrossOrigin
public class ReservationRestController {

	@Autowired
	ReservationRepository  rr;
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(ReservationRepository.class);

	
	@RequestMapping("/reservations/{id}")
	public Reservation findreservation(@PathVariable("id")  Long id) {
		LOGGER.info("inside Findreservation for id"+id);
		return rr.findById(id).orElse(null);
		}
	
	
	@RequestMapping("/reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest req) {
		Reservation reservation = rr.findById(req.getId()).orElse(null);
		reservation.setNumberOfBags(req.getNumberOfBags());
		reservation.setCheckedIn(req.getCheckedIn());
		return rr.save(reservation);
		
	}
}
