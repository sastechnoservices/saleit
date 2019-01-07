package com.saleit.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.saleit.domains.Shop;
import com.saleit.util.ConnectionClass;

public class ShopDao {
	public void insertDatatoShopTable(Shop shop) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c=connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		 String sql = "INSERT INTO rtl_shop (shop_id,shop_name,shop_address,contact_number,email_address,shop_type) "
		            + "VALUES ('12347', 'Paul', '32', 'California', 'asdas','asdsa' );";
		         stmt.executeUpdate(sql);
		         stmt.close();
		       
		         c.close();
	}
	
}
