package com.saleit.login.requestresponse;

public class LoginResponse{

	private String token;
	private Boolean valid;
	private LoginError loginError;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Boolean getValid() {
		return valid;
	}
	public void setValid(Boolean valid) {
		this.valid = valid;
	}
	public LoginError getLoginError() {
		return loginError;
	}
	public void setLoginError(LoginError loginError) {
		this.loginError = loginError;
	}
	
}
