package com.saleit.domains;

public class CartItems {
private String itemId;
private double itemQuantity;
private double itemPrice;
public CartItems() {
	super();
}
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public double getItemQuantity() {
	return itemQuantity;
}
public void setItemQuantity(double itemQuantity) {
	this.itemQuantity = itemQuantity;
}
public double getItemPrice() {
	return itemPrice;
}
public void setItemPrice(double itemPrice) {
	this.itemPrice = itemPrice;
}
public CartItems(String itemId, double itemQuantity, double itemPrice) {
	super();
	this.itemId = itemId;
	this.itemQuantity = itemQuantity;
	this.itemPrice = itemPrice;
}
}
