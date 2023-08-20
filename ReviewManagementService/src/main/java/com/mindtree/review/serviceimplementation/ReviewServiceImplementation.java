package com.mindtree.review.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.review.entity.Review;
import com.mindtree.review.exception.ReviewNotFoundException;
import com.mindtree.review.repository.ReviewRepository;
import com.mindtree.review.service.ReviewService;

@Service
public class ReviewServiceImplementation implements ReviewService
{

	@Autowired
	private ReviewRepository reviewRepo;
	
	
	@Override
	public Review createReview(Review review) 
	{
		return reviewRepo.save(review);
		
	}

	@Override
	public List<Review> getRatingByRestaurantId(String restaurantId) {
		List<Review> reviewData=reviewRepo.findByRestaurantId(restaurantId);
		return reviewData;
	}

	@Override
	public Review updateReview(Review review, int userId) {
		Review customerInfo=reviewRepo.findById(userId).orElseThrow(()->new ReviewNotFoundException(userId));
//		Review customerInfo=reviewRepo.findById(id);
		customerInfo.setRating(review.getRating());
		customerInfo.setResponse(review.getResponse());
		reviewRepo.save(reviewRepo);
		return customerInfo;
	}
	

	
}
