package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.VehicleMovement;
import com.sts.repositories.VehicleMovementRepository;

@Service
public class VehicleMovementService {
	@Autowired
	private VehicleMovementRepository vehicleMovementRepository;


	//Return list of vehicleMovements
	public List<VehicleMovement> getVehicleMovements(){
		return vehicleMovementRepository.findAll();
	}

	//Save new vehicleMovements
	public void save(VehicleMovement vehicleMovements) {
		vehicleMovementRepository.save(vehicleMovements);
	}

	//get by id
	public Optional <VehicleMovement> findById(int id) {
		return vehicleMovementRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		 vehicleMovementRepository.deleteById(id);

	}
}
