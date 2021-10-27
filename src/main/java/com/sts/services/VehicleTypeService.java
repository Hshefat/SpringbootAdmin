package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Location;
import com.sts.models.VehicleType;
import com.sts.repositories.LocationRepository;
import com.sts.repositories.VehicleTypeRepository;

@Service
public class VehicleTypeService {


	@Autowired
	private VehicleTypeRepository vehicleTypeRepository;


	//Return list of vehicleTypes
	public List<VehicleType> getVehicleType(){
		return vehicleTypeRepository.findAll();
	}

	//Save new vehicleTypes
	public void save(VehicleType vehicleTypes) {
		vehicleTypeRepository.save(vehicleTypes);
	}

	//get by id
	public Optional <VehicleType> findById(int id) {
		return vehicleTypeRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		vehicleTypeRepository.deleteById(id);

	}
}
