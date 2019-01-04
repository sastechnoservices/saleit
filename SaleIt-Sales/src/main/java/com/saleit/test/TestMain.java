package com.saleit.test;

import java.sql.SQLException;

import com.saleit.dao.ItemDao;
import com.saleit.dao.ShopDao;
import com.saleit.domains.Items;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.services.AddItemtoCart;

public class TestMain {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
	AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("789");
		addItemtoCartRequest.setShopId("12346");
		addItemtoCartRequest.setUserId("1236");
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
		
				
		/*Items items = new Items();	
		items.setAvailability("Y");
		items.setItemDescription("EggRoll");
		items.setItemName("EggRoll");
		items.setItemId("789");
		items.setItemPrice("45.2");
		items.setShopId("12346");
		ItemDao itemDao = new ItemDao();
		itemDao.insertDatatoItemTable(items);*/
	}

}
