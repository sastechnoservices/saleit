package com.saleit.test;

import java.sql.SQLException;

import org.junit.Test;

import com.saleit.dao.ItemDao;
import com.saleit.dao.ShopDao;
import com.saleit.domains.Items;
import com.saleit.domains.Shop;
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
		Shop shop = new Shop();
		ItemDao itemDao = new ItemDao();
		ShopDao shopDao = new ShopDao();
		shopDao.insertDatatoShopTable(shop);
		items.setAvailability("Y");
		items.setItemDescription("Chilly");
		items.setItemName("Chilly");
		items.setItemId("354");
		items.setItemPrice(65.5);
		items.setShopId("12347");
		itemDao.insertDatatoItemTable(items);
		System.out.println("Item Added To Table");
	}
	
	@Test
	public void testAddItemToCart(){
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("300001");
		addItemtoCartRequest.setShopId("10001");
		addItemtoCartRequest.setUserId("107");
		addItemtoCartRequest.setQuantity(2.8);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
	}
	@Test
	public void testMultipleTimesAddItemToCart(){
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("300001");
		addItemtoCartRequest.setShopId("10001");
		addItemtoCartRequest.setUserId("107");
		addItemtoCartRequest.setQuantity(2);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
		addItemtoCartRequest.setItemid("300001");
		addItemtoCartRequest.setShopId("10001");
		addItemtoCartRequest.setUserId("107");
		addItemtoCartRequest.setQuantity(3);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
	}
	@Test
	public void testMultipleAddItemToCart(){
		AddItemtoCartRequest addItemtoCartRequest = new AddItemtoCartRequest(); 
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		addItemtoCartRequest.setItemid("300009");
		addItemtoCartRequest.setShopId("10001");
		addItemtoCartRequest.setUserId("107");
		addItemtoCartRequest.setQuantity(2);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
		addItemtoCartRequest.setItemid("300010");
		//addItemtoCartRequest.setShopId("12347");
		addItemtoCartRequest.setUserId("10001");
		addItemtoCartRequest.setQuantity(3);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
		addItemtoCartRequest.setItemid("300008");
		addItemtoCartRequest.setShopId("10001");
		addItemtoCartRequest.setUserId("107");
		addItemtoCartRequest.setQuantity(3);
		System.out.println(addItemtoCart.addItemTocart(addItemtoCartRequest).getMessage());
	}
	@Test
	public void testChangeQuantity(){
		//testMultipleTimesAddItemToCart();
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		ChangeQuantityRequest changeQuantityRequest = new ChangeQuantityRequest();
		changeQuantityRequest.setCartName("cart_107");
		changeQuantityRequest.setItemId("300001");
		changeQuantityRequest.setQuantity(2.0);
		System.out.println(addItemtoCart.changeQuantityInCart(changeQuantityRequest).getMessage());
	}
	@Test
	public void testCalculateTotal(){
		//testMultipleTimesAddItemToCart();
		CalculateTotalRequest calculateTotalRequest = new CalculateTotalRequest();
		calculateTotalRequest.setCartName("cart_107");
		AddItemtoCart addItemtoCart = new AddItemtoCart();
		System.out.println(addItemtoCart.calculateTotal(calculateTotalRequest).getMessage());
		System.out.println(addItemtoCart.calculateTotal(calculateTotalRequest).getTotalAmount());
	}
	
}
