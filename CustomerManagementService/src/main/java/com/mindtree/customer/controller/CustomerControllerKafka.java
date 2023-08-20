package com.mindtree.customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.customer.entity.Customer;
import com.mindtree.customer.entity.CustomerEvent;
import com.mindtree.customer.serviceImplementation.CustomerProducer;

@RestController
@RequestMapping("/api/v1")
public class CustomerControllerKafka 
{

	
	private CustomerProducer custprod;
	
	
	
	public CustomerControllerKafka(CustomerProducer custprod) {
		super();
		this.custprod = custprod;
	}

	@PostMapping("/customer")
	public String placeCustomer(@RequestBody Customer customer)
	{
		CustomerEvent customerevent=new CustomerEvent();
		customerevent.setStatus("PENDING");
		customerevent.setMessage("Customer status is in pending state");
		customerevent.setCustomer(customer);
		custprod.sendMesage(customerevent);
		
		return "Customer data placed successfully......";
		
	}
	
}
