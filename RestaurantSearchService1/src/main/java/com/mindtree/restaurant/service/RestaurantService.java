package com.mindtree.restaurant.service;

import java.util.List;

import com.mindtree.restaurant.entity.Restaurant;

public interface RestaurantService 
{
	public Restaurant createRestaurant(Restaurant restaurent);
	public List<Restaurant> getRestaurentByName(String name);
	public List<Restaurant> getRestaurentByLocation(String location);
	public List<Restaurant> getRestaurentByDistance(int distance);
	public List<Restaurant> getRestaurentByCuisine(String cusine);
	public List<Restaurant> getRestaurentByBudget(int budget);
	public List<Restaurant> getRestaurentByRating(double rating);
//	public Restaurant getRating(String userId);
	
	

}
