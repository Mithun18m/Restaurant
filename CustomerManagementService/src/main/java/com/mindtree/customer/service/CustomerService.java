package com.mindtree.customer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindtree.customer.entity.Customer;

public interface CustomerService 
{

	public Customer saveCustomer(Customer customer)throws JsonProcessingException;
	public Customer updateCustomer(Customer customer,int id);
	public void deleteCustomerById(int id);
	
}
