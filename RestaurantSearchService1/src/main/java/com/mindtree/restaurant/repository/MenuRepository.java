package com.mindtree.restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.mindtree.restaurant.entity.MenuItem;

public interface MenuRepository extends JpaRepository<MenuItem,Integer>
{

    public List<MenuItem> findAllByRestaurantIdAndItemName(@Param("restaurantId") String restaurantId, @Param("itemName") String itemName);
    public List<MenuItem> findByitemName(@Param("itemName") String itemName);
    List<MenuItem> findAllMenusByRestaurantId(@Param("restaurantId") String restaurantId);
    
//    public Menu createMenuItem(@RequestBody Menu menuItem);
    
    public String findRestaurantById(@Param("restaurantId") String restaurantId);
}
