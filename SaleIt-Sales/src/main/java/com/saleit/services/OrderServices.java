package com.saleit.services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.saleit.constants.SaleItSuccessMessages;
import com.saleit.constants.SaleitErrorConstatns;
import com.saleit.constants.SaleitErrorMessages;
import com.saleit.constants.SaleitSuccessConstatnts;
import com.saleit.dao.ItemDao;
import com.saleit.dao.OrderDao;
import com.saleit.domains.CartItems;
import com.saleit.domains.Items;
import com.saleit.domains.OrderItemDetails;
import com.saleit.domains.Orders;
import com.saleit.requestresponse.FetchOrderRequest;
import com.saleit.requestresponse.FetchOrderResponse;
import com.saleit.requestresponse.SubmitOrderRequest;
import com.saleit.requestresponse.SubmitOrderResponse;

public class OrderServices {
	public SubmitOrderResponse submitOrder(SubmitOrderRequest submitOrderRequest) {
		CommonServices commonServices = new CommonServices();
		SubmitOrderResponse  orderResponse = new SubmitOrderResponse();
		ItemDao itemDao= new ItemDao();
		Orders orders = new Orders();
		List<OrderItemDetails> orderItemDetailsList = new ArrayList<OrderItemDetails>();
		List<Items> itemList =new ArrayList<Items>();
		orders.setTotalAmount(submitOrderRequest.getTotalAmount());
		orders.setAmountToBePaid(submitOrderRequest.getTotalAmount());
		orders.setCustomerId(submitOrderRequest.getUserID());
		List<CartItems> cartItemList =new ArrayList<CartItems>();
		orders.setOrderDate(new Date());
		try {
			itemList= itemDao.fetchAllItems();
			cartItemList= itemDao.fetchAllItemsFromCart(submitOrderRequest.getCartName());
			for(Items item:itemList) {
				if(null!=cartItemList && !cartItemList.isEmpty() && null!= cartItemList.get(0) && cartItemList.get(0).getItemId().equals(item.getItemId())) {
					orders.setShopId(item.getShopId());
					break;
				}
				
				}
		
			for(CartItems cartItems:cartItemList) {
				OrderItemDetails orderItemDetails = new OrderItemDetails();
				orderItemDetails.setItems(commonServices.fetchItemByItemId(cartItems.getItemId()));
				orderItemDetails.setOrderQuantity(cartItems.getItemQuantity());
				orderItemDetailsList.add(orderItemDetails);
			}
			orders.setItemdetails(orderItemDetailsList);
			orders.setOrderID(commonServices.generateOrderNumber(submitOrderRequest.getUserID()));
			OrderDao orderDao =new OrderDao();
			orderDao.insertToOrder(orders);
			itemDao.dropCart(submitOrderRequest.getCartName());
			orderResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ADDITEMTOCART_004);
			orderResponse.setMessage(SaleItSuccessMessages.SUCC_ADDITEMTOCART_004);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			orderResponse.setMessageCode(SaleitErrorConstatns.ERROR_ADDITEMTOCART_010);
			orderResponse.setMessage(SaleitErrorMessages.ERROR_ADDITEMTOCART_010);
		}
		return orderResponse;
	}
	
	public FetchOrderResponse fetchOrder(FetchOrderRequest fetchOrderRequest) {
		FetchOrderResponse fetchOrderResponse = new FetchOrderResponse();
		return fetchOrderResponse; 
	}
}
