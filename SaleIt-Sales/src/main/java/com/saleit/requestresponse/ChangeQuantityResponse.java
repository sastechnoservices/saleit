package com.saleit.requestresponse;

public class ChangeQuantityResponse {
	private String message;
	private String messageCode;
public ChangeQuantityResponse() {
	super();
}
public ChangeQuantityResponse(String message, String messageCode) {
	super();
	this.message = message;
	this.messageCode = messageCode;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getMessageCode() {
	return messageCode;
}
public void setMessageCode(String messageCode) {
	this.messageCode = messageCode;
}
}
