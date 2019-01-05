package com.saleit.requestresponse;

public class AddItemtoCartResponse {
	private String messageCode;
	private String message;
	private String cartName;
public AddItemtoCartResponse(String messageCode, String message, String cartName) {
	super();
	this.messageCode = messageCode;
	this.message = message;
	this.cartName = cartName;
}
public AddItemtoCartResponse() {
	super();
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
public String getCartName() {
	return cartName;
}
public void setCartName(String cartName) {
	this.cartName = cartName;
}
}
