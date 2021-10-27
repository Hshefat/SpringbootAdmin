package com.sts.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sts.models.Invoice;
import com.sts.models.Location;
import com.sts.repositories.InvoiceRepository;
import com.sts.repositories.LocationRepository;

@Service
public class InvoiceService {


	@Autowired
	private InvoiceRepository invoiceRepository;


	//Return list of invoices
	public List<Invoice> getInvoices(){
		return invoiceRepository.findAll();
	}

	//Save new invoices
	public void save(Invoice invoices) {
		invoiceRepository.save(invoices);
	}

	//get by id
	public Optional <Invoice> findById(int id) {
		return invoiceRepository.findById(id);
	}

	//delete
	public void delete(Integer id) {
		invoiceRepository.deleteById(id);

	}
}
