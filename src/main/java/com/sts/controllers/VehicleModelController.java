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
import com.sts.models.VehicleModel;
import com.sts.models.VehicleModel;
import com.sts.services.VehicleModelService;

@Controller
public class VehicleModelController {

	
	
	/*
	 * @GetMapping("/vehiclemodels") public String getVehicleModel() { return
	 * "vehicleModel"; }
	 */
	
	
	
	@Autowired  
	private VehicleModelService vehicleModelService;

	@GetMapping("/vehiclemodels")
	public String getVehicleModels(Model model) {
		List<VehicleModel> vehicleModelList = vehicleModelService.getVehicleModels();
		model.addAttribute("vehicleModels", vehicleModelList);

		 

		return "vehicleModel";
	}

	// adding
	@PostMapping("/vehiclemodels/addNew")
	public String addNew(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodels";
	}

	// fetching id
	@RequestMapping("vehiclemodels/findById")
	@ResponseBody
	public Optional<VehicleModel> findById(int id) {
		return vehicleModelService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/vehiclemodels/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(VehicleModel vehicleModel) {
		vehicleModelService.save(vehicleModel);
		return "redirect:/vehiclemodels";
	}

	// Delete
	@RequestMapping(value = "/vehiclemodels/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		vehicleModelService.delete(id);
		return "redirect:/vehiclemodels";
	}
}
