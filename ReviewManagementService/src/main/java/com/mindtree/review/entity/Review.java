package com.mindtree.review.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Review 
{

    @Id
    private String ratingId;
    
    private String userId;
    private String restaurantId;
    private  int rating;
    private  String response;
    
	public String getRatingId() {
		return ratingId;
	}
	public void setRatingId(String ratingId) {
		this.ratingId = ratingId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public Review(String ratingId, String userId, String restaurantId, int rating, String response) {
		super();
		this.ratingId = ratingId;
		this.userId = userId;
		this.restaurantId = restaurantId;
		this.rating = rating;
		this.response = response;
	}
	public Review() {
		super();
	}
    
    
}
