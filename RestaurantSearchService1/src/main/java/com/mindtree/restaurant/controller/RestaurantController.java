package com.mindtree.restaurant.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.restaurant.entity.Restaurant;
import com.mindtree.restaurant.serviceimplementation.RestaurantServicetImplementation;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController 
{
	@Autowired
	private RestaurantServicetImplementation restaurentImpl;
	
	private Map<String,Object> response;
	
	//localhost:8081/restaurant/createRestaurent
	@PostMapping("/createRestaurent")
	public ResponseEntity<Map<String,Object>> createRestaurent(@RequestBody Restaurant restaurent) {

		response=new HashMap<String,Object>();
		response.put("message","Restaurent added successfully");
		response.put("status",HttpStatus.OK);
		response.put("body",restaurentImpl.createRestaurant(restaurent));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//localhost:8081/restaurant/RestaurentsByName/{name}
	@GetMapping("/RestaurentsByName/{restaurantName}")
	public ResponseEntity<Map<String,Object>>getRestaurentByName(@PathVariable String restaurantName) {

		response=new HashMap<String,Object>();
		response.put("message","List of Restaurents found by name");
		response.put("status",HttpStatus.OK);
		response.put("body",restaurentImpl.getRestaurentByName(restaurantName));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//@GetMapping maps HTTP Get requests onto specific handler methods.
	//localhost:8081/restaurant/RestaurentsByLocation/{location}
	@GetMapping("/RestaurentsByLocation/{location}")
	public ResponseEntity<Map<String,Object>>getRestaurentByLocation(@PathVariable String location) {

		response=new HashMap<String,Object>();
		response.put("message","List of Restaurents found by location");
		response.put("status",HttpStatus.OK);
		response.put("body",restaurentImpl.getRestaurentByLocation(location));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//@GetMapping maps HTTP Get requests onto specific handler methods.
	//localhost:8081/restaurant/RestaurentsByDistance/{distance}
	@GetMapping("/RestaurentsByDistance/{distance}")
	public ResponseEntity<Map<String,Object>>getRestaurentByDistance(@PathVariable int distance) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List of Restaurents found by distance");
		response.put("status",HttpStatus.OK);
		response.put("body",restaurentImpl.getRestaurentByDistance(distance));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//@GetMapping maps HTTP Get requests onto specific handler methods.
	//localhost:8081/restaurant/RestaurentsByCuisine/{cuisine}
	@GetMapping("/RestaurentsByCuisine/{cuisine}")
	public ResponseEntity<Map<String,Object>>getRestaurentBycuisine(@PathVariable String cuisine) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List of Restaurents found by cuisine");
		response.put("status",HttpStatus.OK);
		response.put("body",restaurentImpl.getRestaurentByCuisine(cuisine));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//@GetMapping maps HTTP Get requests onto specific handler methods.
	//localhost:8081/restaurant/RestaurentsByBudget/{budget}
	@GetMapping("/RestaurentsByBudget/{budget}")
	public ResponseEntity<Map<String,Object>>getRestaurentByBudget(@PathVariable int budget) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List of Restaurents found by budget");
		response.put("status",HttpStatus.OK);
		response.put("body", restaurentImpl.getRestaurentByBudget(budget));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	@GetMapping("/RestaurentsByRating/{rating}")
	public ResponseEntity<Map<String,Object>>getRestaurentByRating(@PathVariable double rating ) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List of Restaurents found by rating");
		response.put("status",HttpStatus.OK);
		response.put("body", restaurentImpl.getRestaurentByRating(rating));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}


}
