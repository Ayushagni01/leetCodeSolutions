package com.location.web.flight.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.web.flight.entities.Flight;
import com.location.web.flight.repos.FlightRepository;

@Controller
public class FlightController {
	
	@Autowired
	FlightRepository fr;
	
	private static final org.slf4j.Logger LOGGER=LoggerFactory.getLogger(FlightController.class);
	
	@RequestMapping("findFlights")
	public String findFlights(@RequestParam("from") String from,@RequestParam("to") String to ,@RequestParam("departureDate") @DateTimeFormat(pattern="MM-dd-yyyy") Date departureDate,ModelMap mmap) {
		LOGGER.info("Inside FindFlights()"+"{"+"from"+from+"}"+"{"+"To"+to+"}"+"{ Departure Date"+departureDate+"}");
		//List<Flight> flights = fr.findFlights(from,departureDate,to);
		List<Flight> flights = fr.findFlights(from,to);
		  boolean ans = flights.isEmpty();
		mmap.addAttribute("flights", flights);
		LOGGER.info("Flight Founds Are:"+flights);
		return "displayFlights";
		
	}
	
	@RequestMapping("admin/ShowAddFlight")
	public String showAddFlight()
	{
		return "addFlight";
	}
	

}
