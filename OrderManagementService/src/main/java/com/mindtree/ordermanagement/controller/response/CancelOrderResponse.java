package com.mindtree.ordermanagement.controller.response;

public class CancelOrderResponse 
{
	
	//This is the class for CancelOrderResponse
    private String orderStatus;

	public String getStatus() {
		return orderStatus;
	}
	public void setStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public CancelOrderResponse( String orderStatus) {
		super();
	
		this.orderStatus = orderStatus;
	}
	public CancelOrderResponse() {
		super();
	}

}
