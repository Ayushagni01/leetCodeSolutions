package com.location.web.flightcheckin.integration;

import com.location.web.flightcheckin.dto.Reservation;
import com.location.web.flightcheckin.dto.ReservationUpdateRequest;

public interface ReservationRestClient {

	public Reservation	findReservation(Long id);
	
	public Reservation updateReservation(ReservationUpdateRequest req);
	
	
	
}
