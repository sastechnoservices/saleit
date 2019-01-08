package com.saleit.requestresponse;

import java.util.List;

import com.saleit.domains.Orders;

public class FetchOrderResponse {
private List<Orders> orders;
private String messageCode;
private String message;
public FetchOrderResponse( List<Orders> orders, String messageCode, String message) {
	super();
	this.orders = orders;
	this.messageCode = messageCode;
	this.message = message;
}
public FetchOrderResponse() {
	super();
}
public  List<Orders> getOrders() {
	return orders;
}
public void setOrders( List<Orders> orders) {
	this.orders = orders;
}
public String getMessageCode() {
	return messageCode;
}
public void setMessageCode(String messageCode) {
	this.messageCode = messageCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
}
