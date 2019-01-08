package com.sastechnoservices.saleit.rest.serviceimpl;

import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.AddItemtoCartResponse;
import com.saleit.services.AddItemtoCart;
import com.sastechnoservices.saleit.webservices.SaleItServices;

public class SaleItServiceImpl implements SaleItServices {

	@Override
	public String testServices() {
		return "Success";
	}

	
	@Override
	public AddItemtoCartResponse addItemtoCart(AddItemtoCartRequest addItemtoCartRequest) {
		AddItemtoCartResponse addItemtoCartResponse = new AddItemtoCartResponse();
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartResponse= addItemtoCart.addItemTocart(addItemtoCartRequest);
		return addItemtoCartResponse;
	}


	

	
	
}
