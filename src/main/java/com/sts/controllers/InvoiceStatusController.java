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

import com.sts.models.InvoiceStatus;
import com.sts.services.InvoiceStatusService;



@Controller
public class InvoiceStatusController {

	
	
	/*
	 * @GetMapping("/invoicestatuses") public String getInvoiceStatus() { return
	 * "invoiceStatus"; }
	 */
	
	
	
	@Autowired  private InvoiceStatusService invoiceStatusService;

	@GetMapping("/invoiceStatuses")
	public String getStates(Model model) {		
		
		List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuss();
		model.addAttribute("invoiceStatuses", invoiceStatusList);
		return "invoiceStatus";
	}	
	
	@PostMapping("/invoiceStatuses/addNew")
	public String addNew(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping("invoiceStatuses/findById")
	@ResponseBody
	public Optional<InvoiceStatus> findById(int id) {
	  return invoiceStatusService.findById(id);	
	}	
	
	@RequestMapping(value="/invoiceStatuses/update", method= {RequestMethod.PUT, RequestMethod.GET})
	public String update(InvoiceStatus invoiceStatus) {
		invoiceStatusService.save(invoiceStatus);
		return "redirect:/invoiceStatuses";
	}
	
	@RequestMapping(value="/invoiceStatuss/delete", method= {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer id) {
		invoiceStatusService.delete(id);
		return "redirect:/invoiceStatuses";
	}
}
