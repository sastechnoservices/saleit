package com.saleit.domains;

public class User {

	String userId;
	Name userName;
	String userContactNumber;
	String userEmailaddress;
	Address userAddress;
	String password;
	String UserType;
	public User() {
		super();
	}
	public User(String userId, Name userName, String userContactNumber, String userEmailaddress, Address userAddress,
			String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userContactNumber = userContactNumber;
		this.userEmailaddress = userEmailaddress;
		this.userAddress = userAddress;
		this.password = password;
		UserType = userType;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Name getUserName() {
		return userName;
	}
	public void setUserName(Name userName) {
		this.userName = userName;
	}
	public String getUserContactNumber() {
		return userContactNumber;
	}
	public void setUserContactNumber(String userContactNumber) {
		this.userContactNumber = userContactNumber;
	}
	public String getUserEmailaddress() {
		return userEmailaddress;
	}
	public void setUserEmailaddress(String userEmailaddress) {
		this.userEmailaddress = userEmailaddress;
	}
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return UserType;
	}
	public void setUserType(String userType) {
		UserType = userType;
	}
	
}
