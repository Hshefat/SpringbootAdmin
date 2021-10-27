package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.VehicleMaintenance;
import com.sts.repositories.VehicleMaintanenceRepository; 

@Service
public class VehicleMaintenanceService {
	@Autowired
	private VehicleMaintanenceRepository vehicleMaintenanceRepository;


	//Return list of sehicleMaintenances
	public List<VehicleMaintenance> getVehicleMaintenances(){
		return vehicleMaintenanceRepository.findAll();
	}

	//Save new sehicleMaintenances
	public void save(VehicleMaintenance sehicleMaintenances) {
		vehicleMaintenanceRepository.save(sehicleMaintenances);
	}

	//get by id
	public Optional <VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		vehicleMaintenanceRepository.deleteById(id);

	}
}
