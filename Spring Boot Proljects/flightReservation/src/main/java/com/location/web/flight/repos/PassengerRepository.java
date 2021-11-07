package com.location.web.flight.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.location.web.flight.entities.Passenger;


public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
