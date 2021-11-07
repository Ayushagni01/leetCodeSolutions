package com.location.web.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.location.web.entities.Location;
import com.location.web.repos.LocationRepository;

@RestController
@RequestMapping("/locations")
public class LoationRestController {

	
	
	@Autowired
	LocationRepository lr;
	
	
	@GetMapping
	public List<Location> getLocations(){ //get all locations
		return lr.findAll();
		
	}
	
	@PostMapping
	public Location createLoction(@RequestBody Location l)
	{
		return lr.save(l);
	}
	
	//put for update
	@PutMapping
	public Location updateLocation(@RequestBody Location l)
	{
		return lr.save(l);
	}
	
	@DeleteMapping("/{id}")
	public void deleteLocation(@PathVariable("id") int id)
	{
		
		lr.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Optional<Location> getOneRecord(@PathVariable("id") int id)
	{
		Location ls=new Location();
		ls.setId(id);
		return lr.findById(id);
	
	}
}
