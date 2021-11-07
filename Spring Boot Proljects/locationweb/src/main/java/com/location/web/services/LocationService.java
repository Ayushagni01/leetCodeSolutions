package com.location.web.services;

import java.util.List;

import com.location.web.entities.Location;

public interface LocationService {
	
	Location saveLocation(Location l);
	Location updateLocation(Location l);
	void deleteLocation(Location l);
	Location getLocationByid(int id);
	List<Location> getAllLocation();
	
	
	

}
