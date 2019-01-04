package com.salit.validations;

import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.exceptions.BusinessException;
import com.saleit.requestresponse.AddItemtoCartRequest;

public class AddItemtoCartValidations {
	public void validateAddItemToCartRequest(AddItemtoCartRequest addItemtoCartRequest) throws BusinessException {
		if(null==addItemtoCartRequest) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_001, SaleitErrorMessages.ERROR_ADDITEMTOCART_001);
			}
		if(null==addItemtoCartRequest.getItemid()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_001, SaleitErrorMessages.ERROR_ADDITEMTOCART_001);
			}
		if(null==addItemtoCartRequest.getShopId()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_002, SaleitErrorMessages.ERROR_ADDITEMTOCART_002);
			}
		if(null==addItemtoCartRequest.getUserId()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_003, SaleitErrorMessages.ERROR_ADDITEMTOCART_003);
			}
		
		}
}
