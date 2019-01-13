package com.saleit.requestresponse;

public class DeleteItemFromCartRequest {
	private String cartId;
	private String itemId;
	public DeleteItemFromCartRequest() {
		super();
	}
	public DeleteItemFromCartRequest(String cartId, String itemId) {
		super();
		this.cartId = cartId;
		this.itemId = itemId;
	}
	public String getCartId() {
		return cartId;
	}
	public void setCartId(String cartId) {
		this.cartId = cartId;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}


}
