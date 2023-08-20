package com.mindtree.ordermanagement.controller.response;

import com.mindtree.ordermanagement.entity.ItemsDetail;

public class CustomerResponse 
{
	//This is the class for CustomerResponse
	private String restaurantId;
    private ItemsDetail itemDetail;
    private int totalPrice;
    private long orderTime;
    private long deliveryTime;
    private String paymentId;
    private String customerName;
    private String customerTableNo;
    private String orderStatus;
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
	public String getCustomerCellNo() {
		return customerTableNo;
	}
	public void setCustomerCellNo(String customerCellNo) {
		this.customerTableNo = customerCellNo;
	}
	public String getStatus() {
		return orderStatus;
	}
	public void setStatus(String status) {
		this.orderStatus = status;
	}
	public CustomerResponse(String restaurantId, ItemsDetail itemDetail, int totalPrice, long orderTime,
			long deliveryTime, String paymentId, String customerName, String customerTableNo,
			String orderStatus) {
		super();
		this.restaurantId = restaurantId;
		this.itemDetail = itemDetail;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.paymentId = paymentId;
		this.customerName = customerName;
		this.customerTableNo = customerTableNo;
		this.orderStatus = orderStatus;
	}
	
	public CustomerResponse() {
		super();
	}

}
