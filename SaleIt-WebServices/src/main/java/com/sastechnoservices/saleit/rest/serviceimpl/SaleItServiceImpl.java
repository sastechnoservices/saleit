package com.sastechnoservices.saleit.rest.serviceimpl;

import com.saleit.login.requestresponse.LoginRequest;
import com.saleit.login.requestresponse.LoginResponse;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.AddItemtoCartResponse;
import com.saleit.requestresponse.CalculateTotalRequest;
import com.saleit.requestresponse.CalculateTotalResponse;
import com.saleit.requestresponse.ChangeQuantityRequest;
import com.saleit.requestresponse.ChangeQuantityResponse;
import com.saleit.requestresponse.DeleteItemFromCartRequest;
import com.saleit.requestresponse.DeleteItemFromCartResponse;
import com.saleit.services.AddItemtoCart;
import com.saleit.services.LoginService;
import com.sastechnoservices.saleit.webservices.SaleItServices;

public class SaleItServiceImpl implements SaleItServices {
	
	AddItemtoCart addItemtoCart = new AddItemtoCart();

	@Override
	public String testServices() {
		return "Success";
	}

	
	@Override
	public AddItemtoCartResponse addItemtoCart(AddItemtoCartRequest addItemtoCartRequest) {
		return addItemtoCart.addItemTocart(addItemtoCartRequest);
	}


	@Override
	public ChangeQuantityResponse changeQuantityInCart(ChangeQuantityRequest changeQuantityRequest) {
		return addItemtoCart.changeQuantityInCart(changeQuantityRequest);
	}


	@Override
	public CalculateTotalResponse calculateTotal(CalculateTotalRequest calculateTotalRequest) {
		return addItemtoCart.calculateTotal(calculateTotalRequest);
	}


	@Override
	public DeleteItemFromCartResponse deleteItemFromCart(DeleteItemFromCartRequest deleteItemFromCartRequest) {
		return addItemtoCart.deleteItemFromCart(deleteItemFromCartRequest);
	}


	@Override
	public LoginResponse login(LoginRequest request) {
		return new LoginService().login(request);
	}


	

	
	
}
