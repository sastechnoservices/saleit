package com.saleit.requestresponse;

public class SubmitOrderResponse {
	private String messageCode;
	private String message;
	private String orderTotal;
	private String orderId;
	public SubmitOrderResponse() {
		super();
	}
	public SubmitOrderResponse(String messageCode, String message, String orderTotal, String orderId) {
		super();
		this.messageCode = messageCode;
		this.message = message;
		this.orderTotal = orderTotal;
		this.orderId = orderId;
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
	public String getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(String orderTotal) {
		this.orderTotal = orderTotal;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	};
}
