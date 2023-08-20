package com.mindtree.customer.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.customer.exception.CustomerNotFoundException;
import com.mindtree.customer.serviceImplementation.CustomerServiceImplementation;

@RestControllerAdvice
public class CustomerExceptionHandler 
{

	private final Logger logger1=LoggerFactory.getLogger(CustomerServiceImplementation.class);
	
	@ExceptionHandler(value=CustomerNotFoundException.class)
	public ResponseEntity<Object> CustomerNotFoundException(CustomerNotFoundException ae)
	{
		String name="provide the correct customer Id";
		logger1.error("Exception in customer.message- {}",name);
		return new ResponseEntity<Object>("The Customer is not found in the database",HttpStatus.NOT_FOUND);
	}
}
