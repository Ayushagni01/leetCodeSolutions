package com.location.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.location.web.entities.Location;
import com.location.web.repos.LocationRepository;

@Service
public class LocationServiceImpl implements LocationService{

	@Autowired
	LocationRepository r;
	
	@Override
	public Location saveLocation(Location l) {
		
		return r.save(l);
	}

	@Override
	public Location updateLocation(Location l) {
		
		return r.save(l);
	}

	@Override
	public void deleteLocation(Location l) {
		r.delete(l);
		
	}

	@Override
	public Location getLocationByid(int id) {
		return r.findById(id).get();
		
	}

	@Override
	public List<Location> getAllLocation() {
		return r.findAll();
	}

}
