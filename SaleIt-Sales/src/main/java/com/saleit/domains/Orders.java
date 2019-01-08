package com.saleit.domains;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Orders {

	private List<OrderItemDetails> itemdetails;
	private String orderID;
	private Double totalAmount;
	private Double amountToBePaid;
	private String shopId;
	private String customerId;
	private String orderStatus;
	private Date orderDate;
	public Orders() {
		super();
	}
	public Orders(List<OrderItemDetails> itemdetails, String orderID, Double totalAmount,
			Double amountToBePaid, String shopId, String customerId, String orderStatus, Date orderDate) {
		super();
		this.itemdetails = itemdetails;
		this.orderID = orderID;
		this.totalAmount = totalAmount;
		this.amountToBePaid = amountToBePaid;
		this.shopId = shopId;
		this.customerId = customerId;
		this.orderStatus = orderStatus;
		this.orderDate = orderDate;
	}
	public List<OrderItemDetails> getItemdetails() {
		return itemdetails;
	}
	public void setItemdetails(List<OrderItemDetails> itemdetails) {
		this.itemdetails = itemdetails;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public Double getAmountToBePaid() {
		return amountToBePaid;
	}
	public void setAmountToBePaid(Double amountToBePaid) {
		this.amountToBePaid = amountToBePaid;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
}
