package com.mindtree.restaurant.serviceimplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.restaurant.entity.MenuItem;
import com.mindtree.restaurant.repository.MenuRepository;
import com.mindtree.restaurant.service.MenuService;

@Service
public class MenuServiceImplementation implements MenuService
{

	@Autowired
	private MenuRepository menurepo;
	
	
	@Override
	public List<MenuItem> findAllMenuByRestaurantIdAnditemName(String restaurantId, String itemName) {
		
		List<MenuItem> items=menurepo.findAllByRestaurantIdAndItemName(restaurantId, itemName);
		return items;
	}

	@Override
	public List<MenuItem> findByitemName(String itemName) {
		
		List<MenuItem> items=menurepo.findByitemName(itemName);
		return items;
	}

	@Override
	public MenuItem createMenuItem(MenuItem menu) {
		
		return menurepo.save(menu);
	}

	@Override
	public List<MenuItem> findAllMenusByRestaurantId(String restaurantId) {
		List<MenuItem> items=menurepo.findAllMenusByRestaurantId(restaurantId);
		return items ;
	}

	@Override
	public String findRestaurantById(String restaurantId) {
		// TODO Auto-generated method stub
		String items=menurepo.findRestaurantById(restaurantId);
		return items ;
	}
	
	

}
