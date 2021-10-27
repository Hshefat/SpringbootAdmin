package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.VehicleHire;
import com.sts.repositories.VehicleHireRepository;

@Service
public class VehicleHireService {
	@Autowired
	private VehicleHireRepository vehicleHireRepository;


	//Return list of vehicleHires
	public List<VehicleHire> getVehicleHires(){
		return vehicleHireRepository.findAll();
	}

	//Save new vehicleHires
	public void save(VehicleHire vehicleHires) {
		vehicleHireRepository.save(vehicleHires);
	}

	//get by id
	public Optional <VehicleHire> findById(int id) {
		return vehicleHireRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		 vehicleHireRepository.deleteById(id);

	}
}
