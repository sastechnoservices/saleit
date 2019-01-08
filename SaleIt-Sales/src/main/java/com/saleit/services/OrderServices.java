package com.saleit.services;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.saleit.exceptions.BusinessException;
import com.saleit.requestresponse.FetchOrderRequest;
import com.saleit.requestresponse.FetchOrderResponse;
import com.saleit.requestresponse.SubmitOrderRequest;
import com.saleit.requestresponse.SubmitOrderResponse;
import com.salit.validations.OrderSeviceValidation;

public class OrderServices {
	public SubmitOrderResponse submitOrder(SubmitOrderRequest submitOrderRequest) {
		OrderSeviceValidation orderSeviceValidation =new OrderSeviceValidation();
		SubmitOrderResponse  orderResponse = new SubmitOrderResponse();
		try {
			orderSeviceValidation.validateSubmitOrderRequest(submitOrderRequest);
		 
		CommonServices commonServices = new CommonServices();
		
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
			orderResponse.setMessageCode(SaleitSuccessConstatnts.SUCC_ORDERSERVICE_001);
			orderResponse.setMessage(SaleItSuccessMessages.SUCC_ORDERSERVICE_001);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			orderResponse.setMessageCode(SaleitErrorConstatns.ERROR_ORDERSERVICE_003);
			orderResponse.setMessage(SaleitErrorMessages.ERROR_ORDERSERVICE_003);
		}
		}
		catch (BusinessException e1) {
			// TODO Auto-generated catch block
			orderResponse.setMessageCode(e1.getMessageCode());
			orderResponse.setMessage(e1.getMessage());
		}
		return orderResponse;
	}
	
	public FetchOrderResponse fetchOrder(FetchOrderRequest fetchOrderRequest) {
		FetchOrderResponse fetchOrderResponse = new FetchOrderResponse();
		OrderSeviceValidation orderSeviceValidation = new OrderSeviceValidation();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			orderSeviceValidation.validateFetchOrderRequest(fetchOrderRequest);
			OrderDao orderDao =new OrderDao();
		try {
			List<Orders> allOrders = orderDao.fetchAllOrders();
			List<Orders> responseOrders = new ArrayList<Orders>();
			if(null!=fetchOrderRequest.getOrderId() && null==fetchOrderRequest.getOrderStatus() &&  null==fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(orders.getOrderID().equals(fetchOrderRequest.getOrderId())) {
						responseOrders.add(orders);
					}
					
				}
				
				
			}
			else if(null==fetchOrderRequest.getOrderId() && null!=fetchOrderRequest.getOrderStatus() &&  null==fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(orders.getOrderStatus().equals(fetchOrderRequest.getOrderStatus())) {
						responseOrders.add(orders);
					}
					
				}
			}
			else if(null==fetchOrderRequest.getOrderId() && null==fetchOrderRequest.getOrderStatus() &&  null!=fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(dateFormat.format(orders.getOrderDate()).equals(dateFormat.format(fetchOrderRequest.getOrderDate()))) {
						responseOrders.add(orders);
					}
					
				}
			}
			else if(null!=fetchOrderRequest.getOrderId() && null!=fetchOrderRequest.getOrderStatus() &&  null==fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(orders.getOrderID().equals(fetchOrderRequest.getOrderId())) {
						responseOrders.add(orders);
					}
					
				}
				List<Orders> tempOrderList = new ArrayList<Orders>();
				for(Orders orders:responseOrders) {
					if(orders.getOrderStatus().equals(fetchOrderRequest.getOrderStatus())) {
						tempOrderList.add(orders);
					}
				}
				responseOrders= tempOrderList;
				
			}
			else if(null!=fetchOrderRequest.getOrderId() && null==fetchOrderRequest.getOrderStatus() &&  null!=fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(orders.getOrderID().equals(fetchOrderRequest.getOrderId())) {
						responseOrders.add(orders);
					}
					
				}
				List<Orders> tempOrderList = new ArrayList<Orders>();
				for(Orders orders:responseOrders) {
					if(dateFormat.format(orders.getOrderDate()).equals(dateFormat.format(fetchOrderRequest.getOrderDate()))) {
						tempOrderList.add(orders);
					}
				}
				responseOrders= tempOrderList;
				
			}
			else if(null==fetchOrderRequest.getOrderId() && null!=fetchOrderRequest.getOrderStatus() &&  null!=fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(orders.getOrderStatus().equals(fetchOrderRequest.getOrderStatus())) {
						responseOrders.add(orders);
					}
					
				}
				List<Orders> tempOrderList = new ArrayList<Orders>();
				for(Orders orders:responseOrders) {
					if(dateFormat.format(orders.getOrderDate()).equals(dateFormat.format(fetchOrderRequest.getOrderDate()))) {
						tempOrderList.add(orders);
					}
				}
				responseOrders= tempOrderList;
				
			}
			else if(null!=fetchOrderRequest.getOrderId() && null!=fetchOrderRequest.getOrderStatus() &&  null!=fetchOrderRequest.getOrderDate()) {
				for(Orders orders:allOrders) {
					if(orders.getOrderID().equals(fetchOrderRequest.getOrderId())) {
						responseOrders.add(orders);
					}
					
				}
				List<Orders> tempOrderList = new ArrayList<Orders>();
				for(Orders orders:responseOrders) {
					if(orders.getOrderStatus().equals(fetchOrderRequest.getOrderStatus())) {
						tempOrderList.add(orders);
					}
					
				}
				responseOrders= tempOrderList;
				tempOrderList = new ArrayList<Orders>();
				for(Orders orders:responseOrders) {
					if(dateFormat.format(orders.getOrderDate()).equals(dateFormat.format(fetchOrderRequest.getOrderDate()))) {
						tempOrderList.add(orders);
					}
				}
				responseOrders= tempOrderList;
				
			}
			else {
				fetchOrderResponse.setMessage(SaleitErrorConstatns.ERROR_ORDERSERVICE_001);
				fetchOrderResponse.setMessage(SaleitErrorMessages.ERROR_ORDERSERVICE_001);
			}
			if(responseOrders.size()>0) {
				fetchOrderResponse.setMessage(SaleitSuccessConstatnts.SUCC_ORDERSERVICE_002);
				fetchOrderResponse.setMessage(SaleItSuccessMessages.SUCC_ORDERSERVICE_002);
			}
			
		} 
		catch (SQLException e) {
			// TODO Auto-generated catch block
			fetchOrderResponse.setMessageCode(SaleitErrorConstatns.ERROR_ORDERSERVICE_001);
			fetchOrderResponse.setMessage(SaleitErrorMessages.ERROR_ORDERSERVICE_001);
		}
		catch (ParseException e) {
			// TODO Auto-generated catch block
			fetchOrderResponse.setMessageCode(SaleitErrorConstatns.ERROR_ORDERSERVICE_001);
			fetchOrderResponse.setMessage(SaleitErrorMessages.ERROR_ORDERSERVICE_001);
		}
		
		} catch (BusinessException e1) {
			// TODO Auto-generated catch block
			fetchOrderResponse.setMessageCode(e1.getMessageCode());
			fetchOrderResponse.setMessage(e1.getMessage());
		}
		
		return fetchOrderResponse; 
	}
}
