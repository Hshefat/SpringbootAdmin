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
import com.sts.models.Location;
import com.sts.models.State;
import com.sts.services.CountryService;
import com.sts.services.LocationService;
import com.sts.services.StateService;

@Controller
public class LocationController {

	
	
	/*
	 * @GetMapping("/locations") public String getLocation() { return "location"; }
	 */
	
	
	
	@Autowired
	private StateService stateService;
	@Autowired  
	private CountryService countryService;
	@Autowired  
	private LocationService locationService;

	@GetMapping("/locations")
	public String getLocations(Model model) {
		List<State> stateList = stateService.getStates();
		model.addAttribute("states", stateList);

		List<Country> countryList = countryService.getCountries();
		model.addAttribute("countries", countryList);
		
		List<Location> locationList = locationService.getLocations();
		model.addAttribute("locations", locationList);

		return "location";
	}

	// adding
	@PostMapping("/locations/addNew")
	public String addNew(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	// fetching id
	@RequestMapping("locations/findById")
	@ResponseBody
	public Optional<Location> findById(int id) {
		return locationService.findById(id);
	}

	// Edit
	@RequestMapping(value = "/locations/update", method = { RequestMethod.PUT, RequestMethod.GET })
	public String update(Location location) {
		locationService.save(location);
		return "redirect:/locations";
	}

	// Delete
	@RequestMapping(value = "/locations/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String delete(Integer id) {
		locationService.delete(id);
		return "redirect:/locations";
	}
}
