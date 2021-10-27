package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Vehicle;
import com.sts.repositories.VehicleRepository;

@Service
public class VehicleService {
	@Autowired
	private VehicleRepository vehicleRepository;


	//Return list of vehicles
	public List<Vehicle> getVehicles(){
		return vehicleRepository.findAll();
	}

	//Save new vehicles
	public void save(Vehicle vehicles) {
		vehicleRepository.save(vehicles);
	}

	//get by id
	public Optional <Vehicle> findById(int id) {
		return vehicleRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		 vehicleRepository.deleteById(id);

	}
}
