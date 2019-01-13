package com.saleit.userservices.requestresponse;

public class CreateUserRequest {
private String userId;
private String password;
private String mobileNumber;
private String emailId;
public CreateUserRequest() {
	super();
}
public CreateUserRequest(String userId, String password, String mobileNumber, String emailId) {
	super();
	this.userId = userId;
	this.password = password;
	this.mobileNumber = mobileNumber;
	this.emailId = emailId;
}

public String getMobileNumber() {
	return mobileNumber;
}
public void setMobileNumber(String mobileNumber) {
	this.mobileNumber = mobileNumber;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public String getUserId() {
	return userId;
}
public void setUserId(String userId) {
	this.userId = userId;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
};

}
