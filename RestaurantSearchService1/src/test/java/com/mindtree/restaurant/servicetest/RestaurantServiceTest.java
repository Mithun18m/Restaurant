package com.mindtree.restaurant.servicetest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.restaurant.entity.MenuItem;
import com.mindtree.restaurant.entity.Restaurant;
import com.mindtree.restaurant.repository.MenuRepository;
import com.mindtree.restaurant.repository.RestaurantRepository;

@SpringBootTest(classes = {RestaurantServiceTest.class})
public class RestaurantServiceTest 
{
	
	@Autowired
	private RestaurantRepository repo;
	
	@Autowired
	private MenuRepository menuRepo;
	
	@Test
	public void testCreateRestaurant() {
		
		Restaurant restaurent=new Restaurant("1","Chef Pillai","Arabic",10,1000,4.0,"Banglore");	
		Restaurant savedRestaurent=repo.save(restaurent);
		//Assert the response
		assertNotNull(savedRestaurent);
	}

	@Test
	public void testgetRestaurentByName()
	{
		
		String name="Chef Pillai";		
		Restaurant restaurent=(Restaurant) repo.findByName(name).get(0);	
//		List<Restaurant> restaurent= repo.findByName(name).get(0);
		//Assert the response		
		assertThat( restaurent.getName()).isEqualTo(name);
	}
	
	@Test	
	public void testgetRestaurentByLocation()	
	{		
		String location="Banglore";		
		Restaurant restaurent=repo.findByLocation(location).get(0);		
		//Assert the response		
		assertThat(restaurent.getLocation()).isEqualTo(location);
	}
	
	@Test	
	public void testgetRestaurentByDistance()	
	{		
		int distance=1000;		
		Restaurant restaurent=repo.findByDistance(distance).get(0);		
		//Assert the response		
		assertThat(restaurent.getDistance()).isEqualTo(distance);
		
	}
	
	@Test	
	public void testgetRestaurentByBudget()	
	{		
		int budget=600;		
		Restaurant restaurent=repo.findByBudget(budget).get(0);		
	
		//Assert the response		
		assertThat(restaurent.getBudget()).isEqualTo(budget);
	}
	
	@Test	
	public void testgetRestaurentByCuisine()	
	{		
		String cuisine="Indian";		
		Restaurant restaurent=repo.findByCusine(cuisine).get(0);		
		//Assert the response		
		assertThat(restaurent.getCusine()).isEqualTo(cuisine);	
		
	}
	
	@Test	
	public void testCreateMenuItems()	
	{		
		MenuItem menuItem=new MenuItem(1,202,"Veg Biriyani","Delicious",200);		
		MenuItem savedMenuItem=menuRepo.save(menuItem);		
		assertNotNull(savedMenuItem);	
	}
	
	@Test
	public void testFindByName()
	{
		String name="Veg Biriyani";
		MenuItem menuItem=menuRepo.findByitemName(name).get(0);
		assertThat(menuItem.getItemName()).isEqualTo(name);
	}

}
