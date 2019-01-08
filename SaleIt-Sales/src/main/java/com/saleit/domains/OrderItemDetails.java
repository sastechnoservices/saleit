package com.saleit.domains;

public class OrderItemDetails {
private double orderQuantity;
private Items items;
public OrderItemDetails() {
	super();
}
public OrderItemDetails(double orderQuantity, Items items) {
	super();
	this.orderQuantity = orderQuantity;
	this.items = items;
}
public double getOrderQuantity() {
	return orderQuantity;
}
public void setOrderQuantity(double orderQuantity) {
	this.orderQuantity = orderQuantity;
}
public Items getItems() {
	return items;
}
public void setItems(Items items) {
	this.items = items;
}


}
