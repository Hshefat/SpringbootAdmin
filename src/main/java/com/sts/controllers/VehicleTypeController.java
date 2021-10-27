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
import com.sts.models.VehicleType;
import com.sts.models.VehicleType;
import com.sts.services.VehicleTypeService;

@Controller
public class VehicleTypeController {

	
	
	/*
	 * @GetMapping("/vehicletypes") public String getVehicleType() { return
	 * "vehicleType"; }
	 */
	
	
	
	@Autowired  
	private VehicleTypeService vehicleTypeService;

	@GetMapping("/vehicletypes")
	public String getVehicleTypes(Model model) {
		List<VehicleType> vehicleTypeList = vehicleTypeService.getVehicleType();
		model.addAttribute("vehicleTypes", vehicleTypeList);

		 

		return "vehicleType";
	}

	// adding
	@PostMapping("/vehicletypes/addNew")
	public String addNew(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicletypes";
	}

	// fetching id
	@RequestMapping("vehicletypes/findById")
	@ResponseBody
	public Optional<VehicleType> findById(int id) {
		return vehicleTypeService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehicletypes/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleType vehicleType) {
		vehicleTypeService.save(vehicleType);
		return "redirect:/vehicletypes";
	}

	// Delete
	@RequestMapping(value = "/vehicletypes/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleTypeService.delete(id);
		return "redirect:/vehicletypes";
	}
}
