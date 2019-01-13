package com.saleit.services;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.saleit.login.requestresponse.LoginRequest;
import com.saleit.login.requestresponse.LoginResponse;
import com.saleit.security.jwt.JWTTokenProcessor;

public class LoginService {
	
	public LoginResponse login(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		if(request.getToken().startsWith("CREATE ")) {
			try {
				String token = new String(Base64.getDecoder().decode(request.getToken().replace("CREATE ", "")),"UTF-8");
				response.setToken(JWTTokenProcessor.generateToken(token.split(":")[0], token.split(":")[1]));
				response.setValid(JWTTokenProcessor.isTokenValidForUser(response.getToken(), token.split(":")[0]));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else if(request.getToken().startsWith("VALIDATE ")) {
			try {
				String token = new String(Base64.getDecoder().decode(request.getToken().replace("VALIDATE ", "")),"UTF-8");
				response.setValid(JWTTokenProcessor.isTokenValidForUser(token.split(":")[1], token.split(":")[0]));
				if(response.getValid()) {
					response.setToken(token.split(":")[1]);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}else {
			response.setValid(false);
		}
		return response;
	}

}
