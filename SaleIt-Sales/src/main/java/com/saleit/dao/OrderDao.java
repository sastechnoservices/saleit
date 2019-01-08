package com.saleit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.saleit.constants.OrderStatus;
import com.saleit.domains.Items;
import com.saleit.domains.OrderItemDetails;
import com.saleit.domains.Orders;
import com.saleit.util.ConnectionClass;
import com.thoughtworks.xstream.XStream;

public class OrderDao {
	public void insertToOrder(Orders orders) throws SQLException {
		Connection c = null;
		XStream xstream = new XStream();
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	    String sql = "INSERT INTO rtl_order (order_id,order_elements,order_total_amount,order_amount_to_paid,shop_id,customer_id,order_status,order_date) "
				+ "VALUES (?,?,?,?,?,?,?,?);";
		PreparedStatement pst = c.prepareStatement(sql) ;
		pst.setString(1, orders.getOrderID());
		pst.setString(2, xstream.toXML(orders.getItemdetails()));
		pst.setString(3, orders.getTotalAmount().toString());
		pst.setString(4, orders.getAmountToBePaid().toString());
		pst.setString(5, orders.getShopId());
		pst.setString(6, orders.getCustomerId());
		pst.setString(7, OrderStatus.SUBMITED);
		pst.setString(8, dateFormat.format(orders.getOrderDate()));
		pst.executeUpdate();

		pst.close();
		c.close();
	}
	
	public List<Orders> fetchAllOrders() throws SQLException, ParseException {
		List<Orders> allOrders = new ArrayList<Orders>();
		XStream xstream = new XStream();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM rtl_order;" ); 
		while ( rs.next() ) {
			Orders orders = new Orders();
			orders.setOrderID(rs.getString("order_id"));
			orders.setCustomerId(rs.getString("customer_id"));
			orders.setAmountToBePaid(Double.valueOf(rs.getString("order_amount_to_paid")));
			orders.setItemdetails((List<OrderItemDetails>)xstream.fromXML(rs.getString("order_elements")));
			orders.setOrderDate(dateFormat.parse(rs.getString("order_date")));
			orders.setTotalAmount(Double.valueOf(rs.getString("order_total_amount")));
			orders.setShopId(rs.getString("shop_id"));
			orders.setOrderStatus(rs.getString("order_status"));
			allOrders.add(orders);
		}	         
		rs.close();
		stmt.close();

		c.close();
		return allOrders;
	}
}
