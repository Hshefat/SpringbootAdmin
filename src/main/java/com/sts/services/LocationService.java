package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Location;
import com.sts.repositories.LocationRepository;

@Service
public class LocationService {

	

	@Autowired
	private LocationRepository locationRepository;


	//Return list of locations
	public List<Location> getLocations(){
		return locationRepository.findAll();
	}

	//Save new locations
	public void save(Location locations) {
		locationRepository.save(locations);
	}

	//get by id
	public Optional <Location> findById(int id) {
		return locationRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		 locationRepository.deleteById(id);

	}
	
	
}
