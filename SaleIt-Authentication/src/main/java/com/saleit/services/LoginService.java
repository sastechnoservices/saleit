package com.saleit.services;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

import com.saleit.login.requestresponse.LoginError;
import com.saleit.login.requestresponse.LoginRequest;
import com.saleit.login.requestresponse.LoginResponse;
import com.saleit.security.jwt.JWTTokenProcessor;
import com.saleit.security.validator.SecurityValidator;

public class LoginService {
	
	public LoginResponse login(LoginRequest request) {
		LoginResponse response = new LoginResponse();
		if(request.getToken().startsWith("CREATE ")) {
			try {
				String token = new String(Base64.getDecoder().decode(request.getToken().replace("CREATE ", "")),"UTF-8");
				String userName = token.split(":")[0];
				String password = token.split(":")[1];
				if(SecurityValidator.validateUser(userName, password)) {
					response.setToken(JWTTokenProcessor.generateToken(userName, password));
					response.setValid(JWTTokenProcessor.isTokenValidForUser(response.getToken(), userName));
				}else {
					LoginError error = new LoginError();
					error.setCode("ERR_AUTH_001");
					error.setError("Incorrect Username or Password.");
					response.setValid(false);
					response.setLoginError(error);
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				LoginError error = new LoginError();
				error.setCode("ERR_AUTH_002");
				error.setError("Invalid token.");
				response.setValid(false);
				response.setLoginError(error);
			}
		}else if(request.getToken().startsWith("VALIDATE ")) {
			try {
				String token = new String(Base64.getDecoder().decode(request.getToken().replace("VALIDATE ", "")),"UTF-8");
				response.setValid(JWTTokenProcessor.isTokenValidForUser(token.split(":")[1], token.split(":")[0]));
				if(response.getValid()) {
					response.setToken(token.split(":")[1]);
				}
			} catch (UnsupportedEncodingException e) {
				LoginError error = new LoginError();
				error.setCode("ERR_AUTH_002");
				error.setError("Invalid token.");
				response.setValid(false);
				response.setLoginError(error);
				e.printStackTrace();
			}
		}else {
			LoginError error = new LoginError();
			error.setCode("ERR_AUTH_002");
			error.setError("Invalid token.");
			response.setValid(false);
			response.setLoginError(error);
		}
		return response;
	}

}
