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
 
import com.sts.models.VehicleHire; 
import com.sts.services.VehicleHireService;

@Controller
public class VehicleHireController {

	
	
	/*
	 * @GetMapping("/vehiclehires") public String getVehicleHire() { return
	 * "vehicleHire"; }
	 */
	
	
	@Autowired  
	private VehicleHireService vehicleHireService;

	@GetMapping("/vehiclehires")
	public String getVehicleHires(Model model) {
		List<VehicleHire> vehicleHireList = vehicleHireService.getVehicleHires();
		model.addAttribute("vehicleHires", vehicleHireList);

	 

		return "location";
	}

	// adding
	@PostMapping("/vehiclehires/addNew")
	public String addNew(VehicleHire location) {
		vehicleHireService.save(location);
		return "redirect:/vehiclehires";
	}

	// fetching id
	@RequestMapping("vehiclehires/findById")
	@ResponseBody
	public Optional<VehicleHire> findById(int id) {
		return vehicleHireService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehiclehires/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleHire location) {
		vehicleHireService.save(location);
		return "redirect:/vehiclehires";
	}

	// Delete
	@RequestMapping(value = "/vehiclehires/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleHireService.delete(id);
		return "redirect:/vehiclehires";
	}
}
