package com.saleit.requestresponse;

import java.util.Date;

public class FetchOrderRequest {
private String userId;
private String orderId;
private String orderStatus;
private Date orderDate;
public FetchOrderRequest() {
	super();
}
public FetchOrderRequest(String userId, String orderId, String orderStatus, Date date) {
	super();
	this.userId = userId;
	this.orderId = orderId;
	this.orderStatus = orderStatus;
	this.orderDate = date;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
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
public void setDate(Date date) {
	this.orderDate = date;
}

}
