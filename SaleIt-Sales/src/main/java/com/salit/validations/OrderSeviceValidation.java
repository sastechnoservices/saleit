package com.salit.validations;

import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.exceptions.BusinessException;
import com.saleit.requestresponse.FetchOrderRequest;
import com.saleit.requestresponse.SubmitOrderRequest;

public class OrderSeviceValidation {
public void validateFetchOrderRequest(FetchOrderRequest fetchOrderRequest) throws BusinessException {
	if(null==fetchOrderRequest.getUserId()) {
		throw new BusinessException(SaleitErrorConstatns.ERROR_ORDERSERVICE_002, SaleitErrorMessages.ERROR_ORDERSERVICE_002);
	}
}

public void validateSubmitOrderRequest(SubmitOrderRequest submitOrderRequest) throws BusinessException {
	if(null==submitOrderRequest.getCartName()) {
		throw new BusinessException(SaleitErrorConstatns.ERROR_ORDERSERVICE_003, SaleitErrorMessages.ERROR_ORDERSERVICE_003);
	}
}
}
