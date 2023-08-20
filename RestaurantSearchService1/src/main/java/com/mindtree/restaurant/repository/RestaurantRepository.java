package com.mindtree.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.restaurant.entity.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,String>
{

	public List<Restaurant> findByName(String restaurantName);

	public List<Restaurant> findByLocation(String location);

	public List<Restaurant> findByDistance(int distance);

	public List<Restaurant> findByCusine(String cuisine);

	public List<Restaurant> findByBudget(int budget);

	public List<Restaurant> findByRating(double rating);

}
