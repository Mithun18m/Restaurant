package com.mindtree.review.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindtree.review.entity.Review;
import com.mindtree.review.service.ReviewService;

@RestController
@RequestMapping("/review")
public class ReviewController 
{


	@Autowired
    private ReviewService reviewService;
    
	
	//localhost:8084/review/saveReview
	@PostMapping("/saveReview")
    public ResponseEntity<Review> create(@RequestBody Review review) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.createReview(review));
    }
	
	
	//localhost:8084/review/restaurant/{restaurantId}
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<Review>> getRatingsByHotelId(@PathVariable String restaurantId) {
        return ResponseEntity.ok(reviewService.getRatingByRestaurantId(restaurantId));
    }
	
    
    //localhost:8084/review/update-review/{userId}
	@PutMapping("/update-review/{userId}")
	public ResponseEntity<?> updateCustomer(@RequestBody Review review, @PathVariable int userId) throws JsonProcessingException
	{
		if(review == null)
		{
			return ResponseEntity.badRequest().body("Error");
		}
		
			return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.updateReview(review,userId));	
	}
    
	
    
	
	
}
