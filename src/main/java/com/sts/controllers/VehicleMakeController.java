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
 
import com.sts.models.VehicleMake; 
import com.sts.services.VehicleMakeService;

@Controller
public class VehicleMakeController {

	
	
	/*
	 * @GetMapping("/vehiclemakes") public String getVehicleMake() { return
	 * "vehicleMake"; }
	 */
	
	
	
	@Autowired  
	private VehicleMakeService vehicleMakeService;

	@GetMapping("/vehiclemakes")
	public String getVehicleMakes(Model model) {
		List<VehicleMake> vehicleMakeList = vehicleMakeService.getVehicleMakes();
		model.addAttribute("states", vehicleMakeList);
 
		return "vehicleMake";
	}

	// adding
	@PostMapping("/vehiclemakes/addNew")
	public String addNew(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	// fetching id
	@RequestMapping("vehiclemakes/findById")
	@ResponseBody
	public Optional<VehicleMake> findById(int id) {
		return vehicleMakeService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehiclemakes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleMake vehicleMake) {
		vehicleMakeService.save(vehicleMake);
		return "redirect:/vehiclemakes";
	}

	// Delete
	@RequestMapping(value = "/vehiclemakes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleMakeService.delete(id);
		return "redirect:/vehiclemakes";
	}
}
