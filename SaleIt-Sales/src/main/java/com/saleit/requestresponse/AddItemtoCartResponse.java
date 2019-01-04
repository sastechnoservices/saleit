package com.saleit.requestresponse;

public class AddItemtoCartResponse {
String messageCode;
String message;
public AddItemtoCartResponse(String messageCode, String message) {
	super();
	this.messageCode = messageCode;
	this.message = message;
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
}
