package com.location.web.flight.services;

import com.location.web.flight.dto.ReservationRequest;
import com.location.web.flight.entities.Reservation;

public interface ReservationService {
	
	public Reservation bookFlight(ReservationRequest request);

	
	
}
