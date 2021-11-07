package com.location.web.flightcheckin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.web.flightcheckin.dto.Reservation;
import com.location.web.flightcheckin.dto.ReservationUpdateRequest;
import com.location.web.flightcheckin.integration.ReservationRestClientImpl;

@Controller
public class checkInController {
	
	@Autowired
	ReservationRestClientImpl rrc;
	
	
	
	@RequestMapping("/showStartCheckIn")
	public String showStartCheckIn()
	{
		return "startCheckIn";
		
	}
	
	@RequestMapping("/startCheckIn")
	public String startCheckIn(@RequestParam("reservationId") Long id,ModelMap mmap)
	{
		Reservation reservation = rrc.findReservation(id);
		mmap.addAttribute("reservation",reservation);
		return "displayReservationDetails";
		
	}
	
	@RequestMapping("/completeCheckIn")
	public String completeCheckIn(@RequestParam("reservationId")Long reservationId, @RequestParam("numberOfBags") int numberOfBags)
	{
		
		
		ReservationUpdateRequest req = new ReservationUpdateRequest();
		req.setId(reservationId);
		req.setCheckedIn(true);
		req.setNumberOfBags(numberOfBags);
		rrc.updateReservation(req);
		
		
		return "checkInConfirmation";
		
	}
	
	
	

}
