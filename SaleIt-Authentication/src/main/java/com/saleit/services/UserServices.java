package com.saleit.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.dao.UserDao;
import com.saleit.domains.User;
import com.saleit.exceptions.BusinessException;
import com.saleit.userservices.requestresponse.CreateUserRequest;
import com.saleit.userservices.requestresponse.CreateUserResponse;
import com.saleit.userservices.validation.UserServicesValidation;

public class UserServices {

	public CreateUserResponse createUser(CreateUserRequest createUserRequest) {
		CreateUserResponse createUserResponse = new CreateUserResponse();
		UserServicesValidation userServicesValidation = new UserServicesValidation();
		try {
			userServicesValidation.validateCreateUserRequest(createUserRequest);
			UserDao userDao = new UserDao();
			StringBuffer userId= new StringBuffer();
			List<User> userList = new ArrayList<User>();
			userList= userDao.fetchAllUsers();
			if(null==createUserRequest.getUserId()) {
				int size= userList.size();
				userId.append(createUserRequest.getMobileNumber());
				userId.append("_");
				userId.append(Integer.toString(size+1));
			}
			else {
				userId.append(createUserRequest.getUserId().toString());
			}
			userDao.createUser(userId.toString(), encrypt(createUserRequest.getPassword(),createUserRequest.getMobileNumber()), createUserRequest.getMobileNumber(), createUserRequest.getEmailId());
			
		} catch (BusinessException e) {
			createUserResponse.setMessage(e.getMessage());
			createUserResponse.setMessageCode(e.getMessageCode());
		} catch (SQLException e) {
			createUserResponse.setMessage(SaleitErrorMessages.ERROR_USERSERVICES_004);
			createUserResponse.setMessageCode(SaleitErrorConstatns.ERROR_USERSERVICES_004);
		} catch (Exception e) {
			createUserResponse.setMessage(SaleitErrorMessages.ERROR_USERSERVICES_004);
			createUserResponse.setMessageCode(SaleitErrorConstatns.ERROR_USERSERVICES_004);
		}
		return createUserResponse;
	}
	public static String encrypt(String strClearText,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"SAS");
			Cipher cipher=Cipher.getInstance("SAS");
			cipher.init(Cipher.ENCRYPT_MODE, skeyspec);
			byte[] encrypted=cipher.doFinal(strClearText.getBytes());
			strData=new String(encrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	public static String decrypt(String strEncrypted,String strKey) throws Exception{
		String strData="";
		
		try {
			SecretKeySpec skeyspec=new SecretKeySpec(strKey.getBytes(),"SAS");
			Cipher cipher=Cipher.getInstance("SAS");
			cipher.init(Cipher.DECRYPT_MODE, skeyspec);
			byte[] decrypted=cipher.doFinal(strEncrypted.getBytes());
			strData=new String(decrypted);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		return strData;
	}
	
	
}
