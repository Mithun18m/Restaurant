package com.mindtree.customer.serviceImplementation;


import org.apache.kafka.clients.admin.NewTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindtree.customer.entity.Customer;
import com.mindtree.customer.entity.repository.CustomerRepository;
import com.mindtree.customer.exception.CustomerNotFoundException;
import com.mindtree.customer.service.CustomerService;

@Service
public class CustomerServiceImplementation implements CustomerService
{
	@Autowired
	private CustomerRepository customerRepo;
	

	//this will sent the messages from the producer to the topic,here string is a key value pair 

	
	private final Logger log=LoggerFactory.getLogger(CustomerServiceImplementation.class);

//	@Override
//	public Customer saveCustomer(CustomerEvent customerEvent) throws JsonProcessingException 
//	{
//		List<Customer> customer = customerRepo.findByCustomerName(customer.getusername());
//		log.info(String.format("customer event => %s ",customerEvent.toString()));
//		//with inthis send message method we have created a message
//		Message<CustomerEvent> message=MessageBuilder
//				.withPayload(customerEvent)
//				.setHeader(KafkaHeaders.TOPIC, newTopic.name())
//				.build();
//		//and then we use this kafkaTemplate to sent the message to the kafka topic.
//		kafkaTemplate.send(message);
//		log.info("Customer service get Customer request:{}",new ObjectMapper().writeValueAsString(customer));
//		return customerRepo.save(customer);
//	}

	@Override
	public Customer updateCustomer(Customer customer, int id) 
	{
//		Customer customerInfo=customerRepo.findById(id);
		//usage of lambda expressions
		Customer customerInfo=customerRepo.findById(id).orElseThrow(()->new CustomerNotFoundException(id));
		if(customerInfo!=null)
//		customerInfo.setId(customer.getId());
		customerInfo.setUsername(customer.getUsername());
		customerInfo.setPassword(customer.getPassword());
		customerInfo.setMobileNo(customer.getMobileNo());
		customerRepo.save(customerInfo);
		return customerInfo;
	}

	@Override
	public void deleteCustomerById(int id) 
	{
		customerRepo.findById(id).orElseThrow(()->new CustomerNotFoundException(id));
		customerRepo.deleteById(id);
	}
	
	@Override
	public Customer saveCustomer(Customer customer) throws JsonProcessingException 
	{
		log.info("Customer service get Customer request:{}",new ObjectMapper().writeValueAsString(customer));
		return customer;
	}

	

}
