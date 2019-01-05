package com.saleit.requestresponse;

public class AddItemtoCartRequest {

	private String itemid;
	private String shopId;
	private String userId;
	private float quantity;
	public AddItemtoCartRequest() {
		super();
	}
	public AddItemtoCartRequest(String itemid, String shopId, String userId, float quantity) {
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
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	}
