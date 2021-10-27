package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.VehicleModel; 
import com.sts.repositories.VehicleModelRepository; 

@Service
public class VehicleModelService {
	


	@Autowired
	private VehicleModelRepository vehicleModelRepository;


	//Return list of vehicleModels
	public List<VehicleModel> getVehicleModels(){
		return vehicleModelRepository.findAll();
	}

	//Save new vehicleModels
	public void save(VehicleModel vehicleModels) {
		vehicleModelRepository.save(vehicleModels);
	}

	//get by id
	public Optional <VehicleModel> findById(int id) {
		return vehicleModelRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		vehicleModelRepository.deleteById(id);

	}

}
