package com.location.web.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.location.web.entities.Location;
import com.location.web.repos.LocationRepository;
import com.location.web.services.LocationService;
import com.location.web.util.EmailUtil;
import com.location.web.util.ReportUtil;
@Controller
public class LocationController {
	
	@Autowired
	LocationService ser;
	
	@Autowired
	EmailUtil ut;
	
	@Autowired
	LocationRepository repo;
	
	@Autowired
	ReportUtil util;
	
	@Autowired
	ServletContext sc;
	
	@GetMapping("/sc")
	public String ShowCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location,ModelMap mmap)
	{
		Location saveLocation = ser.saveLocation(location);
		String msg="Location saved with id "+saveLocation.getId();
		//model map --handling the response
		mmap.addAttribute("msg", msg);
		//ut.sendEmailStriing("hublearns@gmail.com", "Location Saved", "Location Saved Successfully about to return the response");
		return "createLocation";
	}
	
	
	@RequestMapping("/displayLocations")
	public String displayLocations(ModelMap mmap) {
		List<Location> locations=ser.getAllLocation();
		mmap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	@RequestMapping("/deletelocation")
	public String deletelocation(@RequestParam("id") int id,ModelMap mmap)
	{
		Location location = new Location();
		location.setId(id);
		ser.deleteLocation(location);
		List<Location> locations = ser.getAllLocation();
		mmap.addAttribute("locations", locations);
		return "displayLocations";
	}
	@RequestMapping("/showUpdate")
	public String updatelocation(@RequestParam("id") int id,ModelMap mmap)
	{
		Location location = ser.getLocationByid(id);
		mmap.addAttribute("location", location);
		return "editLocation";
	}
	@RequestMapping("/updateloc")
	public String updateLocation(@ModelAttribute("location") Location location,ModelMap mmap)
	{
		ser.updateLocation(location);
		List<Location> locations = ser.getAllLocation();
		mmap.addAttribute("locations", locations);
		return "displayLocations";
	}
	
	@RequestMapping("/generateReport")
	public String generateReport()
	{
		String path=sc.getRealPath("/");
		List<Object[]> data = repo.findTypeAndTypeCount();
		util.generatePieeChart(path, data);
		return "report";
	}
}
