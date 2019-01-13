package com.salit.validations;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.dao.ItemDao;
import com.saleit.domains.CartItems;
import com.saleit.domains.Items;
import com.saleit.exceptions.BusinessException;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.DeleteItemFromCartRequest;

public class AddItemtoCartValidations {
	public void validateAddItemToCartRequest(AddItemtoCartRequest addItemtoCartRequest) throws BusinessException {
		if(null==addItemtoCartRequest) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_001, SaleitErrorMessages.ERROR_ADDITEMTOCART_001);
			}
		if(null==addItemtoCartRequest.getItemid()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_001, SaleitErrorMessages.ERROR_ADDITEMTOCART_001);
			}
		/*if(null==addItemtoCartRequest.getShopId()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_002, SaleitErrorMessages.ERROR_ADDITEMTOCART_002);
			}*/
		if(null==addItemtoCartRequest.getUserId()) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_003, SaleitErrorMessages.ERROR_ADDITEMTOCART_003);
			}
		
			}
	public void validateCartItems(String cartShopId, String requestShopId) throws BusinessException {
		if(null!=cartShopId	&& !cartShopId.equals(requestShopId)) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_008, SaleitErrorMessages.ERROR_ADDITEMTOCART_008);
		}
		else if(null==cartShopId) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_006, SaleitErrorMessages.ERROR_ADDITEMTOCART_006);

		}
	}
	public void validateDeleteCartItems(DeleteItemFromCartRequest deleteItemFromCartRequest) throws BusinessException, SQLException {
		ItemDao itemDao= new ItemDao();
		boolean available= false;
		List<Items> itemList =new ArrayList<Items>();
		itemList= itemDao.fetchAllItems();
		List<CartItems> cartItemList =new ArrayList<CartItems>();
		cartItemList= itemDao.fetchAllItemsFromCart(deleteItemFromCartRequest.getCartId());
		for(Items items : itemList) {
			if(deleteItemFromCartRequest.getItemId().equals(items.getItemId())) {
				available= true;
				break;
			}
			
		}
		if(!available) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_009, SaleitErrorMessages.ERROR_ADDITEMTOCART_009);
		}
		available= false;
		for(CartItems carItems : cartItemList) {
			if(deleteItemFromCartRequest.getItemId().equals(carItems.getItemId())) {
				available= true;
				break;
			}
			
		}
		if(!available) {
			throw new BusinessException(SaleitErrorConstatns.ERROR_ADDITEMTOCART_010, SaleitErrorMessages.ERROR_ADDITEMTOCART_010);
		}
		
	}
}
