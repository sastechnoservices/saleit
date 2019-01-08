package com.sastechnoservices.saleit.webservices;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.AddItemtoCartResponse;

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

}
