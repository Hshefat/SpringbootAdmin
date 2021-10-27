package com.sts.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.sts.models.Vehicle; 
import com.sts.services.VehicleService;

@Controller
public class VehicleController {
	
	
	/*
	 * @GetMapping("/vehicles") public String getVehicle() { return "vehicle"; }
	 */
	
	
	@Autowired  
	private VehicleService VehicleService;

	@GetMapping("/vehicles")
	public String getvehicles(Model model) {
		List<Vehicle> vehicleList = VehicleService.getVehicles();
		model.addAttribute("vehicles", vehicleList);

		 

		return "Vehicle";
	}

	// adding
	@PostMapping("/vehicles/addNew")
	public String addNew(Vehicle Vehicle) {
		VehicleService.save(Vehicle);
		return "redirect:/vehicles";
	}

	// fetching id
	@RequestMapping("vehicles/findById")
	@ResponseBody
	public Optional<Vehicle> findById(int id) {
		return VehicleService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehicles/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Vehicle Vehicle) {
		VehicleService.save(Vehicle);
		return "redirect:/vehicles";
	}

	// Delete
	@RequestMapping(value = "/vehicles/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		VehicleService.delete(id);
		return "redirect:/vehicles";
	}
}
