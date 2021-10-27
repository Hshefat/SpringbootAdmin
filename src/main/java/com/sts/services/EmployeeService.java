package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Employee;
import com.sts.models.User;
import com.sts.repositories.EmployeeRepository;
import com.sts.repositories.UserRepository;
 

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	private UserRepository userRepository;
	
	//Return list of employees
	public List<Employee> getEmployees(){
		return employeeRepository.findAll();
	}
	
	//SAve new employee
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}
	
	//get by id
	public Optional<Employee> findById(int id) {
		return employeeRepository.findById(id);
	}

	public void delete(Integer id) {
		employeeRepository.deleteById(id);
	}

	public Employee findByUsername(String un) {
		// TODO Auto-generated method stub
		return employeeRepository.findByUsername(un);
	}
	
	//Get employees by keyword
	
	  public List<Employee> findByKeyword(String keyword){ return
	  employeeRepository.findByKeyword(keyword);
	  
	  }
	 
	
	
	
	
	
	
	
	
	
	//Set the Username of the employee where firstname and lastname match
	public void assignUsername(int id){
		Employee employee = employeeRepository.findById(id).orElse(null);
		User user = userRepository.findByFirstnameAndLastname(
				employee.getFirstname(),
				employee.getLastname());
		employee.setUsername(user.getUsername());
		employeeRepository.save(employee);
	}
}
