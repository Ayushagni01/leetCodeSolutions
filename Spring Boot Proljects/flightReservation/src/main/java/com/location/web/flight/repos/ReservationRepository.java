package com.location.web.flight.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.web.flight.entities.Reservation;


public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
