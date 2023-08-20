package com.mindtree.ordermanagement.controller.response;

import java.time.LocalTime;

import com.mindtree.ordermanagement.entity.ItemsDetail;

public class PlacingOrderRequest 
{
	//This is the class for placing order request
	private int orderId;
	private String transactionId;
    private String restaurantId;
    private ItemsDetail itemDetail;
//    private String Itemname;
	private int totalPrice;
    private long orderTime;
    private long deliveryTime;
    private String paymentId;
    private String customerName;
    private String customerTableNo;
    
    
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(String restaurantId) {
		this.restaurantId = restaurantId;
	}
	public ItemsDetail getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(ItemsDetail itemDetail) {
		this.itemDetail = itemDetail;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}

	
	public long getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(long deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getcustomerTableNo() {
		return customerTableNo;
	}
	public void setcustomerTableNo(String customerCellNo) {
		this.customerTableNo = customerCellNo;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public PlacingOrderRequest(int orderId,String transactionId, String restaurantId, ItemsDetail itemDetail, int totalPrice,
			long orderTime, String specialNote, long deliveryTime, String paymentId, String customerName,
			String customerTableNo) {
		super();
		this.orderId=orderId;
		this.transactionId = transactionId;
		this.restaurantId = restaurantId;
		this.itemDetail = itemDetail;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.paymentId = paymentId;
		this.customerName = customerName;
		this.customerTableNo = customerTableNo;
	}
	public PlacingOrderRequest() {
		super();
	}
	public void setDeliveryTime(LocalTime now) {
		// TODO Auto-generated method stub
		
	}
	public int getPrice() {
		// TODO Auto-generated method stub
		return 0;
	}

}
