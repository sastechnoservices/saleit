package com.saleit.test;

import java.sql.SQLException;

import org.junit.Test;

import com.saleit.dao.ItemDao;
import com.saleit.domains.Items;
import com.saleit.requestresponse.AddItemtoCartRequest;
import com.saleit.requestresponse.CalculateTotalRequest;
import com.saleit.requestresponse.ChangeQuantityRequest;
import com.saleit.services.AddItemtoCart;

public class TestAddItemToCart {
	@Test
	public void testAddItemToItemTable() throws SQLException{
		Items items = new Items();	
		/*items.setAvailability("Y");
		items.setItemDescription("EggRoll");
		items.setItemName("EggRoll");
		items.setItemId("789");
		items.setItemPrice(45.5);
		items.setShopId("12346");*/
		ItemDao itemDao = new ItemDao();
		items.setAvailability("Y");
		items.setItemDescription("Chowmin");
		items.setItemName("Chowmin");
		items.setItemId("123");
		items.setItemPrice(65.5);
		items.setShopId("12346");
		itemDao.insertDatatoItemTable(items);
		System.out.println("Item Added To Table");
	}
	
	@Test
	public void testAddItemToCart(){
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("789");
		addItemtoCartRequest.setShopId("12346");
		addItemtoCartRequest.setUserId("1236");
		addItemtoCartRequest.setQuantity(2.8);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
	}
	@Test
	public void testMultipleTimesAddItemToCart(){
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("789");
		addItemtoCartRequest.setShopId("12346");
		addItemtoCartRequest.setUserId("1236");
		addItemtoCartRequest.setQuantity(2);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
		addItemtoCartRequest.setItemid("789");
		addItemtoCartRequest.setShopId("12346");
		addItemtoCartRequest.setUserId("1236");
		addItemtoCartRequest.setQuantity(3);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
	}
	@Test
	public void testMultipleAddItemToCart(){
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("789");
		addItemtoCartRequest.setShopId("12346");
		addItemtoCartRequest.setUserId("1236");
		addItemtoCartRequest.setQuantity(2);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
		addItemtoCartRequest.setItemid("123");
		addItemtoCartRequest.setShopId("12346");
		addItemtoCartRequest.setUserId("1236");
		addItemtoCartRequest.setQuantity(3);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
	}
	@Test
	public void testChangeQuantity(){
		//testMultipleTimesAddItemToCart();
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		ChangeQuantityRequest changeQuantityRequest = new ChangeQuantityRequest();
		changeQuantityRequest.setCartName("cart_1236");
		changeQuantityRequest.setItemId("789");
		changeQuantityRequest.setQuantity(3.6);
		System.out.println(addItemtoCart.changeQuantityInCart(changeQuantityRequest).getMessage());
	}
	@Test
	public void testCalculateTotal(){
		//testMultipleTimesAddItemToCart();
		CalculateTotalRequest calculateTotalRequest = new CalculateTotalRequest();
		calculateTotalRequest.setCartName("cart_1236");
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		System.out.println(addItemtoCart.calculateTotal(calculateTotalRequest).getMessage());
		System.out.println(addItemtoCart.calculateTotal(calculateTotalRequest).getTotalAmount());
	}
}
