package com.mindtree.ordermanagement.controller.response;


public class OrderResponse 
{
	//This is the class for OrderResponse
	
	private String transactionId;
    private int orderId;
    private String orderStatus;
    private String restaurantId;
    private int totalPrice;
    
    
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getStatus() {
		return orderStatus;
	}
	public void setStatus(String status) {
		this.orderStatus = status;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public OrderResponse(String transactionId, int orderId, String orderStatus, String restaurantId) {
		super();
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.restaurantId = restaurantId;
	}
    
	public OrderResponse() {
		super();
	}


    

}
