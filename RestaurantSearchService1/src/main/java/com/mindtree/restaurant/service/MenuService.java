package com.mindtree.restaurant.service;

import java.util.List;

import com.mindtree.restaurant.entity.MenuItem;

public interface MenuService 
{
	public List<MenuItem> findAllMenuByRestaurantIdAnditemName( String restaurantId,String itemName);
    public List<MenuItem> findByitemName(String itemName);
    public MenuItem createMenuItem(MenuItem menu);
    List<MenuItem> findAllMenusByRestaurantId(String restaurantId);
    
    public String findRestaurantById(String restaurantId);

}
