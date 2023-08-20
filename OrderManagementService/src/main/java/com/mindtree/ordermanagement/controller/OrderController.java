package com.mindtree.ordermanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.ordermanagement.controller.response.PlacingOrderRequest;
import com.mindtree.ordermanagement.exception.OrderException;
import com.mindtree.ordermanagement.service.implementation.OrderServiceImplementation;

@RestController
@RequestMapping("/orders")
public class OrderController 
{
	
    //@Autowired annotation is used for dependency injection.
	@Autowired
	private OrderServiceImplementation orderImpl;
	
	private Map<String,Object> response;
	
	//localhost:8082/orders/createOrder/2
	@PostMapping("/createOrder/{restaurantId}")
	public ResponseEntity<Map<String,Object>> createOrder(@RequestBody PlacingOrderRequest placingOrder,@PathVariable String restaurantId) 
	{
		//HashMap stores elements in pairs.
		response=new HashMap<String,Object>();
		response.put("message","Order Placed successfully ");
		response.put("status",HttpStatus.OK);
		response.put("body",orderImpl.createOrder(placingOrder));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//localhost:8082/orders/updateOrder
	@PutMapping("/updateOrder")
	public ResponseEntity<Map<String,Object>> updateOrder(@RequestBody PlacingOrderRequest placingOrder) throws OrderException
	{
		response=new HashMap<String,Object>();
		response.put("message","Order updated Successfully");
		response.put("status",HttpStatus.OK);
		response.put("body",orderImpl.updateOrder(placingOrder));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//localhost:8082/orders/cancelOrder/{orderId}
	@DeleteMapping("/cancelOrder/{orderId}")
	public ResponseEntity<Map<String,Object>> cancelOrder(@PathVariable int orderId) throws OrderException
	{
		response=new HashMap<String,Object>();
		response.put("message","Order cancelled Successfully !!!");
		response.put("status",HttpStatus.OK);
		response.put("body",orderImpl.cancelOrder(orderId));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//localhost:8082/orders/OrdersBycustomerName/{customerName}
	@GetMapping("/OrdersBycustomerName/{customerName}")
	public ResponseEntity<Map<String,Object>> viewOrdersByCustomerName(@PathVariable String customerName) throws OrderException
	{
		
		//HashMap stores elements in pairs.
		response=new HashMap<String,Object>();
		response.put("message","Orders got successfully");
		response.put("status",HttpStatus.OK);
		response.put("body",orderImpl.viewOrdersByCustomerName(customerName));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
	
	//localhost:8086/orders/total/2
	@GetMapping("/total/{orderId}")
	public ResponseEntity<Map<String, Object>> getOrderAmountByOrderId(@PathVariable int orderId)
	{
		response=new HashMap<String,Object>();
		response.put("message","Total Amount for your Order got successfully");
		response.put("status",HttpStatus.OK);
		response.put("Total Amount",orderImpl.getOrderAmountByOrderId(orderId));
		return new ResponseEntity<Map<String,Object>>(response,HttpStatus.OK);
	}
}
