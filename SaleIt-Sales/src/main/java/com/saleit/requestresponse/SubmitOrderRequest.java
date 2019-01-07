package com.saleit.requestresponse;

public class SubmitOrderRequest {

	private String cartName;
	private double totalAmount;
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	private String userID;
	public SubmitOrderRequest() {
		super();
	}
	public SubmitOrderRequest(String cartName, String userID,double totalAmount) {
		super();
		this.cartName = cartName;
		this.totalAmount = totalAmount;
		this.userID = userID;
	}
	public String getCartName() {
		return cartName;
	}
	public void setCartName(String cartName) {
		this.cartName = cartName;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
