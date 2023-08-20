package com.mindtree.ordermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mindtree.ordermanagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order,Integer>
{

//	List<Order> findByCustomerName(String customerName, String name);
//	List<Order> findByCustomerNameAndItemDetailName(String customerName, String name);
	List<Order> findByRestaurantId(String restaurantId);
	Order getByOrderIdAndCustomerName(int orderId, String customerName);
	List<Order> findByCustomerName(String customerName);
	
	List<Order> findByOrderId(int orderId);
	List<Order> findByCustomerNameAndItemDetailName(String customerName, String name);
}
