package com.saleit.requestresponse;

public class DeleteItemFromCartResponse {
private String itemName;
private String message;
private String messageCode;
public DeleteItemFromCartResponse() {
	super();
}
public DeleteItemFromCartResponse(String itemName, String message, String messageCode) {
	super();
	this.itemName = itemName;
	this.message = message;
	this.messageCode = messageCode;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
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
