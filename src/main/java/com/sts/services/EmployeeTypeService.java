package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Employee;
import com.sts.models.EmployeeType;
import com.sts.models.Location;
import com.sts.models.User;
import com.sts.repositories.EmployeeTypeRepository;
import com.sts.repositories.LocationRepository;

@Service
public class EmployeeTypeService {


	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;


	//Return list of employeeTypes
	public List<EmployeeType> getEmployeeTypes(){
		return employeeTypeRepository.findAll();
	}

	//Save new employeeTypes
	public void save(EmployeeType employeeTypes) {
		employeeTypeRepository.save(employeeTypes);
	}

	//get by id
	public Optional <EmployeeType> findById(int id) {
		return employeeTypeRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		employeeTypeRepository.deleteById(id);

	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
