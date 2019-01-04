package com.saleit.domains;

public class Items {
	
String itemId;
String shopId;
String itemName;
String itemDescription;
String itemPrice;
String availability;
String itemImageId;
public Items() {
	super();
}
public Items(String itemId, String shopId, String itemName, String itemDescription, String itemPrice,
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
public String getItemPrice() {
	return itemPrice;
}
public void setItemPrice(String itemPrice) {
	this.itemPrice = itemPrice;
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
