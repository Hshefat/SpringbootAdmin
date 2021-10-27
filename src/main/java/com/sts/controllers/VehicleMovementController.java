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

import com.sts.models.Country;
import com.sts.models.VehicleMovement;
import com.sts.models.VehicleMovement;
import com.sts.services.VehicleMovementService;

@Controller
public class VehicleMovementController {

	
	
	/*
	 * @GetMapping("/vehiclemovements") public String getVehicleMovement() { return
	 * "vehicleMovement"; }
	 */
	
	
	
	@Autowired  
	private VehicleMovementService vehicleMovementService;

	@GetMapping("/vehiclemovements")
	public String getVehicleMovements(Model model) {
		List<VehicleMovement> vehicleMovementList = vehicleMovementService.getVehicleMovements();
		model.addAttribute("vehicleMovements", vehicleMovementList);
 

		return "vehicleMovement";
	}

	// adding
	@PostMapping("/vehiclemovements/addNew")
	public String addNew(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	// fetching id
	@RequestMapping("vehiclemovements/findById")
	@ResponseBody
	public Optional<VehicleMovement> findById(int id) {
		return vehicleMovementService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehiclemovements/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMovement vehicleMovement) {
		vehicleMovementService.save(vehicleMovement);
		return "redirect:/vehiclemovements";
	}

	// Delete
	@RequestMapping(value = "/vehiclemovements/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMovementService.delete(id);
		return "redirect:/vehiclemovements";
	}
}
