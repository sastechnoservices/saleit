package com.saleit.requestresponse;

public class ChangeQuantityRequest {

	private String itemId;
	private String cartName;
	private float quantity;
	public ChangeQuantityRequest() {
		super();
	}
	public ChangeQuantityRequest(String itemId, String cartName, float quantity) {
		super();
		this.itemId = itemId;
		this.cartName = cartName;
		this.quantity = quantity;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public float getQuantity() {
		return quantity;
	}
	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}
	
}
