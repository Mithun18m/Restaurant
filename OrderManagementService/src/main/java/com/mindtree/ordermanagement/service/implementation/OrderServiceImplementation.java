package com.mindtree.ordermanagement.service.implementation;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.ordermanagement.controller.response.CancelOrderResponse;
import com.mindtree.ordermanagement.controller.response.PlacingOrderRequest;
import com.mindtree.ordermanagement.controller.response.OrderResponse;
import com.mindtree.ordermanagement.entity.Order;
import com.mindtree.ordermanagement.exception.OrderException;
import com.mindtree.ordermanagement.repository.OrderRepository;
import com.mindtree.ordermanagement.service.OrderService;


@Service
public class OrderServiceImplementation  implements OrderService
{

	//@Autowired annotation is used for dependency injection.
	@Autowired
	OrderRepository orderRepo;

	@Override
	public OrderResponse createOrder(PlacingOrderRequest placingOrder) 
	{
		 List<Order> orders = orderRepo.findByCustomerName(placingOrder.getCustomerName());
		 OrderResponse orderResponse = null;
		 if (orders != null && orders.size() == 0)
		 {
			 placingOrder.setTransactionId(UUID.randomUUID().toString());
//			 orderRequest.setTransactionId(UUID.randomUUID().toString());
			 placingOrder.setTotalPrice(placingOrder.getItemDetail().getPrice() * placingOrder.getItemDetail().getQuantity());
			 placingOrder.setOrderTime(System.currentTimeMillis()); 
//			 orderRequest.setDeliveryTime(java.time.LocalTime.now());
//			 orderRequest.setOrderTime(orderRequest.getOrderTime());
			 //currentTimeMillis() method returns the current time in milliseconds.
			 placingOrder.setDeliveryTime(System.currentTimeMillis() + 300000);
			 placingOrder.setPaymentId(placingOrder.getcustomerTableNo() + "_ybl");
			 
	         orderResponse = new OrderResponse();
			 
	         Order order = new Order();
	         BeanUtils.copyProperties(placingOrder, order);
	         order.setorderStatus("New");
	         orderRepo.save(order);
//	         orderResponse.setTotalPrice(placingOrder.getTotalPrice());
//	         orderResponse.setStatus(order.getorderStatus());
//	         orderResponse.setRestaurantId(order.getRestaurantId());
//	         orderResponse.setOrderId(order.getOrderId());
//	         orderResponse.setTransactionId(UUID.randomUUID().toString());
	            }
		    return orderResponse;
	}
	
	
	@Override
	public OrderResponse updateOrder(PlacingOrderRequest placingOrder) throws OrderException {
		OrderResponse orderResponse = null;
        List<Order> orderByOrderId = orderRepo.findByOrderId(placingOrder.getOrderId());
        
        if (orderByOrderId != null && orderByOrderId.size() == 1)
        {
	        Order order = new Order();
	        BeanUtils.copyProperties(placingOrder, order);
	        order.setorderStatus("Updated");
	        orderRepo.save(order);
	        
        	orderResponse = new OrderResponse();
        	
        	orderResponse.setOrderId(order.getOrderId());
        	orderResponse.setRestaurantId(order.getRestaurantId());
        	orderResponse.setStatus(order.getorderStatus());
        	orderResponse.setTransactionId(UUID.randomUUID().toString());
        	orderResponse.setTotalPrice(placingOrder.getItemDetail().getPrice() * placingOrder.getItemDetail().getQuantity());
        } 
        else throw new OrderException("orders not upadated");
        
        return orderResponse;
	}
	
	
	@Override
	public List<Order> viewOrdersByCustomerName(String customerName) throws OrderException {
		// TODO Auto-generated method stub
		 List<Order> orders = orderRepo.findByCustomerName(customerName);
	     return orders;
	}

	@Override
	public CancelOrderResponse cancelOrder(int orderId) throws OrderException
	{
		Optional<Order> order=orderRepo.findById(orderId);
		if(order ==null ) throw new OrderException("OrderId Invalid");
		
		orderRepo.deleteById(orderId);
		
		CancelOrderResponse cancelOrderResponse = new CancelOrderResponse();
		cancelOrderResponse.setStatus("Deleted");
		return  cancelOrderResponse;
		
	}
	
	
	@Override
	public double getOrderAmountByOrderId(int orderId) 
	{
		List<Order> order = orderRepo.findByOrderId(orderId);
		if(order != null)
		{
			double total=0;
			//in each Iteration the variable will hold the value of an element inside the order starting from the first element.
			//in first iteration the it will contain the first element in the list
			//and in second iteration it contains the second element in the list
			//this will continue untill we reach the end of list in order table.
			//we are not using the index here.
			for(Order item: order)
			{
				total = total+(item.getItemDetail().getPrice()*item.getItemDetail().getQuantity());
			}
			return total;
		}
		else 
		{
			return 0;
		}
	}


}
