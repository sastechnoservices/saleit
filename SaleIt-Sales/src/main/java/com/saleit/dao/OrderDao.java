package com.saleit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import com.saleit.constants.OrderStatus;
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
}
