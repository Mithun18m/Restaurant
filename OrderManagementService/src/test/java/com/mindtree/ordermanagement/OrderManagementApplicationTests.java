package com.mindtree.ordermanagement;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mindtree.ordermanagement.entity.ItemsDetail;
import com.mindtree.ordermanagement.entity.Order;
import com.mindtree.ordermanagement.repository.ItemRepository;
import com.mindtree.ordermanagement.repository.OrderRepository;

@SpringBootTest
class OrderManagementApplicationTests {

	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private ItemRepository itemrepo;

	@Test
	public void testCreateOrder()
	{
		Order order = new Order(6,"2",new ItemsDetail(),100,7.15,6.30,"88","Mithun","2222","preparing");
		Order savedOrder=orderRepo.save(order);
		assertNotNull(savedOrder);
		
	}
	
	@Test	
	public void testfindByRestaurantId()	
	{		
		String id="2";		
		Order order=orderRepo.findByRestaurantId(id).get(0);		
		//Assert the response		
		assertThat(order.getRestaurantId()).isEqualTo(id);
	}
	
	@Test	
	public void testfindByCustomerName()	
	{		
		String CustomerName="Mithun";		
		Order order=orderRepo.findByCustomerName(CustomerName).get(0);		
		//Assert the response		
		assertThat(order.getCustomerName()).isEqualTo(CustomerName);
	}
	
	@Test	
	public void testfindByOrderId()	
	{		
		int orderId=6;		
		Order order=orderRepo.findByOrderId(orderId).get(0);		
		//Assert the response		
		assertThat(order.getOrderId()).isEqualTo(orderId);
	}
	
	
	@Test
	public void testCreateMenu()
	{
		ItemsDetail item=new ItemsDetail(1,"Bread",67,5);
		ItemsDetail savedItem=itemrepo.save(item);
		assertNotNull(savedItem);
	}
}