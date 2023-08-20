package com.mindtree.review.service;

import java.util.List;

import com.mindtree.review.entity.Review;

public interface ReviewService 
{
	
	public Review createReview(Review reviewr);
	List<Review> getRatingByRestaurantId(String restaurantId);
	public Review updateReview(Review review,int userId);

}
