package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Location;
import com.sts.models.VehicleStatus;
import com.sts.repositories.LocationRepository;
import com.sts.repositories.VehicleStatusRepository;

@Service
public class VehicleStatusService {


	@Autowired
	private VehicleStatusRepository vehicleStatusRepository;


	//Return list of vehicleStatuss
	public List<VehicleStatus> getVehicleStatuss(){
		return vehicleStatusRepository.findAll();
	}

	//Save new vehicleStatuss
	public void save(VehicleStatus vehicleStatuss) {
		vehicleStatusRepository.save(vehicleStatuss);
	}

	//get by id
	public Optional <VehicleStatus> findById(int id) {
		return vehicleStatusRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		vehicleStatusRepository.deleteById(id);

	}

}
