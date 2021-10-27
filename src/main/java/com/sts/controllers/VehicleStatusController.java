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
import com.sts.models.VehicleStatus;
import com.sts.models.State;
import com.sts.services.VehicleStatusService;

@Controller
public class VehicleStatusController {

	
	/*
	 * @GetMapping("/vehiclestatuses") public String getVehicleStatus() { return
	 * "vehicleStatus"; }
	 */
	
	
	
	
	@Autowired  
	private VehicleStatusService vehicleStatusService;

	@GetMapping("/vehiclestatuses")
	public String getVehicleStatuss(Model model) {
		List<VehicleStatus> vehicleStatusList = vehicleStatusService.getVehicleStatuss();
		model.addAttribute("vehicleStatuss", vehicleStatusList);
 

		return "vehicleStatus";
	}

	// adding
	@PostMapping("/vehiclestatuses/addNew")
	public String addNew(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}

	// fetching id
	@RequestMapping("vehiclestatuses/findById")
	@ResponseBody
	public Optional<VehicleStatus> findById(int id) {
		return vehicleStatusService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehiclestatuses/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleStatus vehicleStatus) {
		vehicleStatusService.save(vehicleStatus);
		return "redirect:/vehiclestatuses";
	}

	// Delete
	@RequestMapping(value = "/vehiclestatuses/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleStatusService.delete(id);
		return "redirect:/vehiclestatuses";
	}
}
