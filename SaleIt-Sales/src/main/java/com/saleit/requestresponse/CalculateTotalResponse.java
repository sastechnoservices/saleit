package com.saleit.requestresponse;

public class CalculateTotalResponse {
	private String messageCode;
	private String message;
	private double totalAmount;
	public CalculateTotalResponse() {
		super();
	}
	public CalculateTotalResponse(String messageCode, String message, double totalAmount) {
		super();
		this.messageCode = messageCode;
		this.message = message;
		this.totalAmount = totalAmount;
	}
	public String getMessageCode() {
		return messageCode;
	}
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	
}
