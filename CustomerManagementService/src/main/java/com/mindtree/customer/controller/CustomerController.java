package com.mindtree.customer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindtree.customer.entity.Customer;
import com.mindtree.customer.entity.CustomerEvent;
import com.mindtree.customer.service.CustomerService;
//import com.mindtree.customer.serviceImplementation.CustomerProducer;

@RestController
@RequestMapping("/register")
public class CustomerController 
{
	
	@Autowired
	private CustomerService customerService;
	
//	private CustomerProducer producer;
	
	private static final Logger logger=	LoggerFactory.getLogger(CustomerController.class);
	
	//localhost:8083/register/customer
	@PostMapping("/customer")
    public ResponseEntity<Customer> registerCustomer(@RequestBody Customer customer) throws Exception
    {
		Customer customerData=customerService.saveCustomer(customer);
//		producer.sendMesage(customerEvent);
    	logger.info("Customer Created Successfully");
    	return new ResponseEntity<Customer>(customerData, HttpStatus.CREATED);
    }
	
	//localhost:8083/register/update-customer/{id}
	@PutMapping("/update-customer/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable int id) throws JsonProcessingException
	{
		if(customer == null)
		{
			return ResponseEntity.badRequest().body("Error");
		}
			logger.info("Customer updated successfully");
			return ResponseEntity.status(HttpStatus.CREATED).body(customerService.updateCustomer(customer, id));
					
		
	}
	
	//localhost:8083/register/delete-customer/{id}
	@DeleteMapping("/delete-customer/{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable int id)
	{
		customerService.deleteCustomerById(id);
		return new ResponseEntity<String>("Customer deleted successfully",HttpStatus.OK);
	}
}
