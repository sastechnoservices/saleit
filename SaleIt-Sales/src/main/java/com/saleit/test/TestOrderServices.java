package com.saleit.test;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import org.junit.Test;

import com.saleit.dao.OrderDao;
import com.saleit.domains.OrderItemDetails;
import com.saleit.domains.Orders;
import com.saleit.requestresponse.SubmitOrderRequest;
import com.saleit.services.OrderServices;

public class TestOrderServices {
	@Test
	public void testSubmitOrder(){
		SubmitOrderRequest submitOrderRequest= new SubmitOrderRequest();
		submitOrderRequest.setCartName("cart_107");
		submitOrderRequest.setTotalAmount(260.0);
		submitOrderRequest.setUserID("107");
		OrderServices orderServices = new OrderServices();
		System.out.println(orderServices.submitOrder(submitOrderRequest).getMessage());
	}
	@Test
	public void testfetchOrders(){
		OrderDao orderDao = new OrderDao();
		try {
			List<Orders>allOrders= orderDao.fetchAllOrders();
			for(Orders orders:allOrders) {
			System.out.println(orders.getOrderID());
			for(OrderItemDetails items:orders.getItemdetails()) {
				System.out.println(items.getOrderQuantity());
				System.out.println(items.getItems().getItemName());
				
			}
			}
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
