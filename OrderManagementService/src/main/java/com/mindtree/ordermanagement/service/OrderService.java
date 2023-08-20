package com.mindtree.ordermanagement.service;

import java.util.List;

import com.mindtree.ordermanagement.controller.response.CancelOrderResponse;
import com.mindtree.ordermanagement.controller.response.PlacingOrderRequest;
import com.mindtree.ordermanagement.controller.response.OrderResponse;
import com.mindtree.ordermanagement.entity.Order;
import com.mindtree.ordermanagement.exception.OrderException;



public interface OrderService 
{
	OrderResponse createOrder(PlacingOrderRequest placingOrder);
    OrderResponse updateOrder(PlacingOrderRequest placingOrder) throws OrderException;
    CancelOrderResponse cancelOrder(int orderId) throws OrderException;
    List<Order> viewOrdersByCustomerName(String customerName) throws OrderException;
	double getOrderAmountByOrderId(int orderiId);
}
