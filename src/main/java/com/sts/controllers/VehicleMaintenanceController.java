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
 
import com.sts.models.VehicleMaintenance; 
import com.sts.services.VehicleMaintenanceService;

@Controller
public class VehicleMaintenanceController {

	
	
	/*
	 * @GetMapping("/vehiclemaintenances") public String getVehicleMaintenance() {
	 * return "vehicleMaintenance"; }
	 */
	
	
	
	@Autowired  
	private VehicleMaintenanceService vehicleMaintenanceService;

	@GetMapping("/vehiclemaintenances")
	public String getVehicleMaintenances(Model model) {
		List<VehicleMaintenance> vehicleMaintenanceList = vehicleMaintenanceService.getVehicleMaintenances();
		model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);
 

		return "vehicleMaintenance";
	}

	// adding
	@PostMapping("/vehiclemaintenances/addNew")
	public String addNew(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}

	// fetching id
	@RequestMapping("vehiclemaintenances/findById")
	@ResponseBody
	public Optional<VehicleMaintenance> findById(int id) {
		return vehicleMaintenanceService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehiclemaintenances/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMaintenance vehicleMaintenance) {
		vehicleMaintenanceService.save(vehicleMaintenance);
		return "redirect:/vehiclemaintenances";
	}

	// Delete
	@RequestMapping(value = "/vehiclemaintenances/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMaintenanceService.delete(id);
		return "redirect:/vehiclemaintenances";
	}
}
