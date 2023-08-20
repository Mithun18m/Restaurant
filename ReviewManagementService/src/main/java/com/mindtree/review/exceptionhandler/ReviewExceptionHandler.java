package com.mindtree.review.exceptionhandler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mindtree.review.exception.ReviewNotFoundException;
import com.mindtree.review.serviceimplementation.ReviewServiceImplementation;


@RestControllerAdvice
public class ReviewExceptionHandler 
{

	private final Logger logger1=LoggerFactory.getLogger(ReviewServiceImplementation.class);
	
	@ExceptionHandler(value=ReviewNotFoundException.class)
	public ResponseEntity<Object> ReviewNotFoundExceptionException(ReviewNotFoundException ae)
	{
		String name="provide the correct Review Id";
		logger1.error("Review in customer.message- {}",name);
		return new ResponseEntity<Object>("The Review is not found in the database",HttpStatus.NOT_FOUND);
	}
}
