package com.mindtree.customer.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.customer.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer,Integer>
{

	void save(CustomerRepository customerRepo);


	
}
