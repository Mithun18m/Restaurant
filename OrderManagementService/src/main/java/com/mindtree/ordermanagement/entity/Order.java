package com.mindtree.ordermanagement.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="Orders")
public class Order 
{
	
	//@Entity represents a table in a relational database.
	@Id
	@Column(name="orderId")
    private int orderId;
	
    @Column(name="restaurantId")
    private String restaurantId;
    
	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn
    private ItemsDetail itemDetail;
    
    @Column(name="totalPrice")
    private int totalPrice;
    
    @Column(name="orderTime")
    private double orderTime;
    
    @Column(name="deliveryTime")
    private double deliveryTime;
    
    @Column(name="paymentId")
    private String paymentId;
    
    @Column(name="customerName")
    private String customerName;
    
    @Column(name="customerTableNo")
    private String customerTableNo;
    
    @Column(name="status")
    private String orderStatus;
    

	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public double getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(long orderTime) {
		this.orderTime = orderTime;
	}
	public double getDeliveryTime() {
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
	public String getorderStatus() {
		return orderStatus;
	}
	public void setorderStatus(String status) {
		this.orderStatus = status;
	}
	public Order(int orderId, String restaurantId,ItemsDetail itemDetail , int totalPrice, double orderTime,
			double deliveryTime, String paymentId, String customerName, String customerTableNo,
			String orderStatus) {
		super();
//		this.id = id;
		this.orderId = orderId;
		this.restaurantId = restaurantId;
		this.itemDetail = itemDetail;
//		this.itemname = itemname;
		this.totalPrice = totalPrice;
		this.orderTime = orderTime;
		this.deliveryTime = deliveryTime;
		this.paymentId = paymentId;
		this.customerName = customerName;
		this.customerTableNo = customerTableNo;
		this.orderStatus = orderStatus;
	}
	
//	public String getItemname() {
//		return itemname;
//	}
//	public void setItemname(String itemname) {
//		this.itemname = itemname;
//	}
	public Order() {
		super();
	}
//	public Order(int i, int j, String string, int k, String string2, String string3, String string4, String string5,
//			String string6, String string7, String string8) {
//		// TODO Auto-generated constructor stub
//	}

    
    


}
