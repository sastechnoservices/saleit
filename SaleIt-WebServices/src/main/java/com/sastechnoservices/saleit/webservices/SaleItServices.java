package com.sastechnoservices.saleit.webservices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

public interface SaleItServices {
	
	@GET
	@Produces("text/plain")
	@Path("/ping")
	String testServices();

}
