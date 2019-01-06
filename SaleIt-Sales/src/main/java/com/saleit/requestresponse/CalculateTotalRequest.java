package com.saleit.requestresponse;

public class CalculateTotalRequest {
	
	String cartName;

	public CalculateTotalRequest() {
		super();
	}

	public CalculateTotalRequest(String cartName) {
		super();
		this.cartName = cartName;
	}

	public String getCartName() {
		return cartName;
	}

	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	
}
