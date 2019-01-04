package com.saleit.domains;

public class Shop {
	String shopID;
	String shopName;
	String shopContactNumber;
	Address shopAddress;
	Name ownerName;
	public Shop() {
		super();
	}
	public Shop(String shopID, String shopName, String shopContactNumber, Address shopAddress, Name ownerName) {
		super();
		this.shopID = shopID;
		this.shopName = shopName;
		this.shopContactNumber = shopContactNumber;
		this.shopAddress = shopAddress;
		this.ownerName = ownerName;
	}
	public String getShopID() {
		return shopID;
	}
	public void setShopID(String shopID) {
		this.shopID = shopID;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopContactNumber() {
		return shopContactNumber;
	}
	public void setShopContactNumber(String shopContactNumber) {
		this.shopContactNumber = shopContactNumber;
	}
	public Address getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(Address shopAddress) {
		this.shopAddress = shopAddress;
	}
	public Name getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(Name ownerName) {
		this.ownerName = ownerName;
	}
	
}
