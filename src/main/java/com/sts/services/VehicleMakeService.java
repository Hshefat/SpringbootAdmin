package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.VehicleMake; 
import com.sts.repositories.VehicleMakeRepository; 

@Service
public class VehicleMakeService {


	@Autowired
	private VehicleMakeRepository vehicleMakeRepository;


	//Return list of vehicleMakes
	public List<VehicleMake> getVehicleMakes(){
		return vehicleMakeRepository.findAll();
	}

	//Save new vehicleMakes
	public void save(VehicleMake vehicleMakes) {
		vehicleMakeRepository.save(vehicleMakes);
	}

	//get by id
	public Optional <VehicleMake> findById(int id) {
		return vehicleMakeRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		 vehicleMakeRepository.deleteById(id);

	}
}
