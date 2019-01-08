package com.saleit.requestresponse;

public class UpdateOrderRequest {
private String orderId;
private String status;
public String getOrderId() {
	return orderId;
}
public void setOrderId(String orderId) {
	this.orderId = orderId;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public UpdateOrderRequest(String orderId, String status) {
	super();
	this.orderId = orderId;
	this.status = status;
}
public UpdateOrderRequest() {
	super();
}
}
