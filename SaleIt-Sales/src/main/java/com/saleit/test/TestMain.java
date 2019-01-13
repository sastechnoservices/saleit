package com.saleit.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.saleit.requestresponse.AddItemtoCartRequest;
import com.thoughtworks.xstream.XStream;

public class TestMain {

	public static void main(String[] args) throws SQLException {
	/*	Address address = new Address();
		XStream xstream = new XStream();	
		address.setAddressLine1("Nandan Vihar");
		address.setAddressLine2("Near Subhadra Appartment");
		address.setCity("Bhubaneswar");
		address.setLandMark("Subhadra Appartment");
		address.setPin("751024");
		String dataXml = xstream.toXML(address);
		System.out.println(dataXml);
		*/
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest();	
		XStream xstream = new XStream();
		//xstream.alias( "AddItemtoCartRequest", AddItemtoCartRequest.class );
		addItemtoCartRequest.setItemid("300001");
		addItemtoCartRequest.setShopId("10001");
		addItemtoCartRequest.setUserId("107");
		addItemtoCartRequest.setQuantity(2);
		String dataXml = xstream.toXML(addItemtoCartRequest);
		List<String> tempList = new ArrayList<String>();
		tempList.add("asdas");
		System.out.println(dataXml);
		
		
	}

}
