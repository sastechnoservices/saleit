package com.saleit.security.validator;

public class SecurityValidator {
	
	private SecurityValidator() {}
	
	public static Boolean validateUser(String username, String password) {
		Boolean isValid = false;
		if(username.equals("8763463143") && password.equals("abc@123")) {
			isValid = true;
		}
		return isValid;
	}

}
