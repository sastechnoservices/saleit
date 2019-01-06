package com.saleit.domains;

public class Items {
	
	private String itemId;
	private String shopId;
	private String itemName;
	private String itemDescription;
	private double itemPrice;
	private String availability;
	private String itemImageId;
public Items() {
	super();
}
public Items(String itemId, String shopId, String itemName, String itemDescription, float itemPrice,
		String availability, String itemImageId) {
	super();
	this.itemId = itemId;
	this.shopId = shopId;
	this.itemName = itemName;
	this.itemDescription = itemDescription;
	this.itemPrice = itemPrice;
	this.availability = availability;
	this.itemImageId = itemImageId;
}
public String getItemId() {
	return itemId;
}
public void setItemId(String itemId) {
	this.itemId = itemId;
}
public String getShopId() {
	return shopId;
}
public void setShopId(String shopId) {
	this.shopId = shopId;
}
public String getItemName() {
	return itemName;
}
public void setItemName(String itemName) {
	this.itemName = itemName;
}
public String getItemDescription() {
	return itemDescription;
}
public void setItemDescription(String itemDescription) {
	this.itemDescription = itemDescription;
}
public double getItemPrice() {
	return itemPrice;
}
public void setItemPrice(double d) {
	this.itemPrice = d;
}
public String getAvailability() {
	return availability;
}
public void setAvailability(String availability) {
	this.availability = availability;
}
public String getItemImageId() {
	return itemImageId;
}
public void setItemImageId(String itemImageId) {
	this.itemImageId = itemImageId;
}


}
