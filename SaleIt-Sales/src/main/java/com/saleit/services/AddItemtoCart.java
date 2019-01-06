package com.saleit.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saleit.constants.SaleItSuccessMessages;
import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.constants.SaleitSuccessConstatnts;
import com.saleit.dao.ItemDao;
import com.saleit.domains.CartItems;
import com.saleit.domains.Items;
import com.saleit.exceptions.BusinessException;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.AddItemtoCartResponse;
import com.saleit.requestresponse.CalculateTotalRequest;
import com.saleit.requestresponse.CalculateTotalResponse;
import com.saleit.requestresponse.ChangeQuantityRequest;
import com.saleit.requestresponse.ChangeQuantityResponse;
import com.salit.validations.AddItemtoCartValidations;

public class AddItemtoCart {
	public AddItemtoCartResponse addItemTocart(AddItemtoCartRequest addItemtoCartRequest) {
		if(addItemtoCartRequest.getQuantity()==0) {
			addItemtoCartRequest.setQuantity(1);
		}
		AddItemtoCartResponse addItemtoCartResponse = new AddItemtoCartResponse();
		AddItemtoCartValidations addItemtoCartValidations = new AddItemtoCartValidations();
		List<Items> itemList =new ArrayList<Items>();
		ItemDao itemDao= new ItemDao();
		StringBuffer cartName =new StringBuffer();
		cartName.append("cart_");
		cartName.append(addItemtoCartRequest.getUserId());
		addItemtoCartResponse.setCartName(cartName.toString());

		try {
			addItemtoCartValidations.validateAddItemToCartRequest(addItemtoCartRequest);
			itemList= itemDao.fetchAllItems();
			Items requestItem = new Items();
			for(Items items:itemList) {
				if(items.getItemId().equals(addItemtoCartRequest.getItemid())) {
					requestItem=items;
					break;
				}
			}
			try {
				requestItem.setItemPrice(requestItem.getItemPrice()*addItemtoCartRequest.getQuantity());
				itemDao.insertToCart(requestItem, cartName.toString(), Double.toString(addItemtoCartRequest.getQuantity()));
				addItemtoCartResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_001);
				addItemtoCartResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_001);
			}
			catch (SQLException e) {
				try {
					itemDao.createCart(cartName.toString());
					itemDao.insertToCart(requestItem, cartName.toString(), Double.toString(addItemtoCartRequest.getQuantity()));
					addItemtoCartResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_001);
					addItemtoCartResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_001);
				}
				catch (SQLException ex) {
					ChangeQuantityRequest changeQuantityRequest = new ChangeQuantityRequest();
					changeQuantityRequest.setCartName(cartName.toString());
					changeQuantityRequest.setItemId(requestItem.getItemId());
					List<CartItems> cartItemList =new ArrayList<CartItems>();
					CartItems cartItems = new CartItems();
					cartItemList= itemDao.fetchAllItemsFromCart(changeQuantityRequest.getCartName());
					boolean itemAvailableinCart= false;
					for(CartItems cartItem:cartItemList) {
						if(cartItem.getItemId().equals(changeQuantityRequest.getItemId())) {
							cartItems = cartItem;
							itemAvailableinCart= true;
							break;
						}
					}
					if(itemAvailableinCart) {
						changeQuantityRequest.setQuantity(cartItems.getItemQuantity()+addItemtoCartRequest.getQuantity());
					}
					ChangeQuantityResponse changeQuantityResponse= changeQuantityInCart(changeQuantityRequest);
					addItemtoCartResponse.setMessageCode(changeQuantityResponse.getMessageCode());
					addItemtoCartResponse.setMessage(changeQuantityResponse.getMessage());
				}


			}

		} 

		catch (SQLException e) {
			// TODO Auto-generated catch block
			addItemtoCartResponse.setMessageCode(SaleitErrorConstatns.ERROR_ADDITEMTOCART_006);
			addItemtoCartResponse.setMessage(SaleitErrorMessages.ERROR_ADDITEMTOCART_006);
		}
		catch (BusinessException e) {
			// TODO Auto-generated catch block
			addItemtoCartResponse.setMessageCode(e.getMessageCode());
			addItemtoCartResponse.setMessage(e.getMessage());
		} 


		return addItemtoCartResponse;
	}

	public ChangeQuantityResponse changeQuantityInCart(ChangeQuantityRequest changeQuantityRequest) {
		ChangeQuantityResponse changeQuantityResponse = new ChangeQuantityResponse();
		ItemDao itemDao= new ItemDao();
		List<Items> itemList =new ArrayList<Items>();
		try {
			itemList= itemDao.fetchAllItems();
			Items requestItem = new Items();
			for(Items items:itemList) {
				if(items.getItemId().equals(changeQuantityRequest.getItemId())) {
					requestItem=items;
					break;
				}
			}
			double itemUnitPrice = requestItem.getItemPrice();
			List<CartItems> cartItemList =new ArrayList<CartItems>();
			cartItemList= itemDao.fetchAllItemsFromCart(changeQuantityRequest.getCartName());
			boolean itemAvailableinCart= false;
			for(CartItems cartItem:cartItemList) {
				if(cartItem.getItemId().equals(changeQuantityRequest.getItemId())) {
					itemAvailableinCart= true;
					break;
				}
			}
			if(itemAvailableinCart) {
				CartItems cartItems = new CartItems();
				cartItems.setItemId(changeQuantityRequest.getItemId());
				double totalPrice =itemUnitPrice*changeQuantityRequest.getQuantity();
				cartItems.setItemQuantity(changeQuantityRequest.getQuantity());
				cartItems.setItemPrice(totalPrice);
				itemDao.updateCart(changeQuantityRequest.getCartName(), cartItems);
			}
			changeQuantityResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_002);
			changeQuantityResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_002);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			changeQuantityResponse.setMessageCode(SaleitErrorConstatns.ERROR_ADDITEMTOCART_005);
			changeQuantityResponse.setMessage(SaleitErrorMessages.ERROR_ADDITEMTOCART_005);
		}
		return changeQuantityResponse;
	}

	public CalculateTotalResponse calculateTotal(CalculateTotalRequest calculateTotalRequest) {
		CalculateTotalResponse calculateTotalResponse =new CalculateTotalResponse();
		ItemDao itemDao= new ItemDao();
		double totalAmount=0;
		List<CartItems> cartItemList =new ArrayList<CartItems>();
		try {
			cartItemList= itemDao.fetchAllItemsFromCart(calculateTotalRequest.getCartName());
			for(CartItems items :cartItemList) {
				totalAmount=totalAmount+items.getItemPrice();
			}
			calculateTotalResponse.setTotalAmount(totalAmount);
			calculateTotalResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_003);
			calculateTotalResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_003);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			calculateTotalResponse.setMessageCode(SaleitErrorConstatns.ERROR_ADDITEMTOCART_007);
			calculateTotalResponse.setMessage(SaleitErrorMessages.ERROR_ADDITEMTOCART_007);
		}
		return calculateTotalResponse;
	}
}
