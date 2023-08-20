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

import com.mindtree.restaurant.entity.MenuItem;
import com.mindtree.restaurant.serviceimplementation.MenuServiceImplementation;

@RestController
@RequestMapping("/restaurant")
public class MenuController 
{
	@Autowired
	private MenuServiceImplementation itemImpl;
	
	private Map<String,Object> response;
	
	//localhost:8081/restaurant/MenuItems
	@PostMapping("/MenuItems")
	public ResponseEntity<Map<String, Object>> createMenuItem(@RequestBody MenuItem menuItem) 
	{
		response=new HashMap<String,Object>();
		response.put("message","MenuItems created successfully");
		response.put("status",HttpStatus.OK);
		response.put("body",itemImpl.createMenuItem(menuItem));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//localhost:8081/restaurant/AllMenusByRestaurentId/{restaurantId}
	@GetMapping("/AllMenusByRestaurentId/{restaurantId}")
	public ResponseEntity<Map<String,Object>>findAllMenusByRestaurantId(@PathVariable String restaurantId) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List Of Menuitems found By RestaurentId");
		response.put("status",HttpStatus.OK);
		response.put("body", itemImpl.findAllMenusByRestaurantId(restaurantId));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
		
	}
	
	
	//localhost:8081/restaurant/AllMenusByRestaurentIdAndName/{restaurantId}/{name}
	@GetMapping("/AllMenusByRestaurentIdAndName/{restaurantId}/{itemName}")
	public ResponseEntity<Map<String,Object>>findAllByRestaurantIdAndName(@PathVariable String restaurantId,@PathVariable String itemName) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List of Menuitems found by restaurentId and name");
		response.put("status",HttpStatus.OK);
		response.put("body", itemImpl.findAllMenuByRestaurantIdAnditemName(restaurantId,itemName));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	
	//localhost:8081/restaurant/findByName/{name}
	@GetMapping("/findByName/{itemName}")
	public ResponseEntity<Map<String,Object>>findByName(@PathVariable String itemName) 
	{

		response=new HashMap<String,Object>();
		response.put("message","List Of Menuitems found By Item Name");
		response.put("status",HttpStatus.OK);
		response.put("body", itemImpl.findByitemName(itemName));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}


}
