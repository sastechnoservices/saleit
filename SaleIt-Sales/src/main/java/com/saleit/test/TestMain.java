package com.saleit.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import com.saleit.dao.ItemDao;
import com.saleit.dao.ShopDao;
import com.saleit.domains.Address;
import com.saleit.domains.Items;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.services.AddItemtoCart;
import com.saleit.services.CommonServices;
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
		    BigDecimal bd = new BigDecimal(12.156);
		    bd = bd.setScale(2, RoundingMode.HALF_UP);
		    System.out.println(bd.doubleValue());
		
	}

}
