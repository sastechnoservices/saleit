package com.saleit.requestresponse;

public class AddItemtoCartRequest {
	private String itemid;
	private String shopId;
	private String userId;
	private double quantity;
	public AddItemtoCartRequest() {
		super();
	}
	public AddItemtoCartRequest(String itemid, String shopId, String userId, double quantity) {
		super();
		this.itemid = itemid;
		this.shopId = shopId;
		this.userId = userId;
		this.quantity = quantity;
	}
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	}
