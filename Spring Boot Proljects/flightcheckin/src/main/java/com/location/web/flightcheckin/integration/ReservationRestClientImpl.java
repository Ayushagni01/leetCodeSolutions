package com.location.web.flightcheckin.integration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.location.web.flightcheckin.dto.Reservation;
import com.location.web.flightcheckin.dto.ReservationUpdateRequest;

@Component
public class ReservationRestClientImpl implements ReservationRestClient {

	@Override
	public Reservation findReservation(Long id) {
		
		RestTemplate rt=new RestTemplate();
		Reservation reservations = rt.getForObject("http://localhost:8052/flight/reservations/"+id, Reservation.class);
		return reservations;
	}

	@Override
	public Reservation updateReservation(ReservationUpdateRequest req) {
		RestTemplate rt=new RestTemplate();
		rt.postForObject("http://localhost:8052/flight/reservations/", req, Reservation.class);
		return null;
	}

}
