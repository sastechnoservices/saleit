package com.saleit.domains;

public class CartItems {
private String itemId;
private float itemQuantity;
private float itemPrice;
public CartItems() {
	super();
}
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public float getItemQuantity() {
	return itemQuantity;
}
public void setItemQuantity(float itemQuantity) {
	this.itemQuantity = itemQuantity;
}
public float getItemPrice() {
	return itemPrice;
}
public void setItemPrice(float itemPrice) {
	this.itemPrice = itemPrice;
}
public CartItems(String itemId, float itemQuantity, float itemPrice) {
	super();
	this.itemId = itemId;
	this.itemQuantity = itemQuantity;
	this.itemPrice = itemPrice;
}
}
