package com.mindtree.ordermanagement.controller.response;

public class CancelOrderRequest 
{
	//This is the class for CancelOrderRequest
	private int orderId;
    private String customerName;
	public int getOrderIds() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
		
		
}
	public CancelOrderRequest(int orderId, String customerName) {
		super();
		this.orderId = orderId;
		this.customerName = customerName;
	}
	public CancelOrderRequest() {
		super();
	}
	

}
