package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.InvoiceStatus; 
import com.sts.repositories.InvoiceStatusRepostiory; 

@Service
public class InvoiceStatusService {


	@Autowired
	private InvoiceStatusRepostiory invoiceStatusRepostiory;


	//Return list of invoiceStatuss
	public List<InvoiceStatus> getInvoiceStatuss(){
		return invoiceStatusRepostiory.findAll();
	}

	//Save new invoiceStatuss
	public void save(InvoiceStatus invoiceStatuss) {
		invoiceStatusRepostiory.save(invoiceStatuss);
	}

	//get by id
	public Optional <InvoiceStatus> findById(int id) {
		return invoiceStatusRepostiory.findById(id);
	}

	//delete
	public void delete(Integer id) {
		invoiceStatusRepostiory.deleteById(id);

	}
}
