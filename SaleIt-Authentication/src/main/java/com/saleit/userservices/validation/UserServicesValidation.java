package com.saleit.userservices.validation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.dao.UserDao;
import com.saleit.domains.User;
import com.saleit.exceptions.BusinessException;
import com.saleit.userservices.requestresponse.CreateUserRequest;

public class UserServicesValidation {
	public void validateCreateUserRequest(CreateUserRequest createUserRequest) throws BusinessException, SQLException {
		UserDao userDao = new UserDao();
		if(null==createUserRequest.getMobileNumber()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_USERSERVICES_005, SaleitErrorMessages.ERROR_USERSERVICES_005);

		}
if(null==createUserRequest.getPassword()) {
	throw new BusinessException(SaleitErrorConstatns.ERROR_USERSERVICES_006, SaleitErrorMessages.ERROR_USERSERVICES_006);

}
		List<User> userList = new ArrayList<User>();
		userList= userDao.fetchAllUsers();
		for(User user:userList) {
			if(null!=createUserRequest.getUserId() && createUserRequest.getUserId().equals(user.getUserId())) {
				throw new BusinessException(SaleitErrorConstatns.ERROR_USERSERVICES_001, SaleitErrorMessages.ERROR_USERSERVICES_001);

			}
			if(null!=createUserRequest.getMobileNumber() && user.getUserContactNumber().equals(createUserRequest.getMobileNumber())) {
				throw new BusinessException(SaleitErrorConstatns.ERROR_USERSERVICES_002, SaleitErrorMessages.ERROR_USERSERVICES_001);

			}
			
			if(null!=createUserRequest.getEmailId() && user.getUserEmailaddress().equals(createUserRequest.getEmailId())) {
				throw new BusinessException(SaleitErrorConstatns.ERROR_USERSERVICES_003, SaleitErrorMessages.ERROR_USERSERVICES_003);

			}
		}
		
		
		
		
		
		
		
		
		
		
	}
}
