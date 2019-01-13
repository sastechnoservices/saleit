package com.sastechnoservices.saleit.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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

public interface SaleItServices {
	
	@GET
	@Produces("text/plain")
	@Path("/ping")
	String testServices();
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addItem")
	AddItemtoCartResponse addItemtoCart(AddItemtoCartRequest addItemtoCartRequest);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/changeItemQuantity")
	ChangeQuantityResponse changeQuantityInCart(ChangeQuantityRequest changeQuantityRequest);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/calculateCartTotals")
	CalculateTotalResponse calculateTotal(CalculateTotalRequest calculateTotalRequest);
	
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/deleteItemFromCart")
	DeleteItemFromCartResponse deleteItemFromCart(DeleteItemFromCartRequest deleteItemFromCartRequest);
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/login")
	LoginResponse login(LoginRequest request);

}
