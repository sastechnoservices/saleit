package com.saleit.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saleit.constants.SaleItSuccessMessages;
import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.constants.SaleitSuccessConstatnts;
import com.saleit.dao.ItemDao;
import com.saleit.domains.Items;
import com.saleit.exceptions.BusinessException;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.AddItemtoCartResponse;
import com.salit.validations.AddItemtoCartValidations;

public class AddItemtoCart {
	public AddItemtoCartResponse addItemTocart(AddItemtoCartRequest addItemtoCartRequest) {
		AddItemtoCartResponse addItemtoCartResponse = new AddItemtoCartResponse();
		AddItemtoCartValidations AddItemtoCartValidations = new AddItemtoCartValidations();
		List<Items> itemList =new ArrayList<Items>();
		ItemDao itemDao= new ItemDao();
        StringBuffer cartName =new StringBuffer();
        cartName.append("cart_");
        cartName.append(addItemtoCartRequest.getUserId());
              
        try {
			AddItemtoCartValidations.validateAddItemToCartRequest(addItemtoCartRequest);
			itemList= itemDao.fetchAllItems();
			Items requestItem = new Items();
			for(Items items:itemList) {
				if(items.getItemId().equals(addItemtoCartRequest.getItemid())) {
					requestItem=items;
					break;
				}
			}
			try {
			itemDao.insertToCart(requestItem, cartName.toString(), Float.toString(addItemtoCartRequest.getQuantity()));
			addItemtoCartResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_001);
			addItemtoCartResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_001);
			}
			catch (SQLException e) {
				try {
				itemDao.createCart(cartName.toString());
				itemDao.insertToCart(requestItem, cartName.toString(), Float.toString(addItemtoCartRequest.getQuantity()));
				addItemtoCartResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_001);
				addItemtoCartResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_001);
				}
				catch (SQLException ex) {
					addItemtoCartResponse.setMessageCode(SaleitErrorConstatns.ERROR_ADDITEMTOCART_004);
					addItemtoCartResponse.setMessage(SaleitErrorMessages.ERROR_ADDITEMTOCART_004);
					
				}
				
				
			}
			
		} 
        
		catch (SQLException e) {
			// TODO Auto-generated catch block
			addItemtoCartResponse.setMessageCode(null);
			addItemtoCartResponse.setMessage(e.getMessage());
		}
		catch (BusinessException e) {
			// TODO Auto-generated catch block
			addItemtoCartResponse.setMessageCode(e.getMessageCode());
			addItemtoCartResponse.setMessage(e.getMessage());
		} 

        
		return addItemtoCartResponse;
	}
}
