package com.saleit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saleit.domains.CartItems;
import com.saleit.domains.Items;
import com.saleit.util.ConnectionClass;

public class ItemDao {
	public void createCart(String cartName) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		String sql = "CREATE TABLE "+ cartName +
				"(item_id varchar(255) PRIMARY KEY     NOT NULL," +
				" item_quantity  varchar(255)    NOT NULL, " +
				" item_price  varchar(255)    NOT NULL); ";
		stmt.executeUpdate(sql);
		stmt.close();
		c.close();
	}
	public void dropCart(String cartName) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		String sql = "Drop TABLE "+ cartName;
		stmt.executeUpdate(sql);
		stmt.close();
		c.close();
	}
	public List<CartItems> fetchAllItemsFromCart(String cartName) throws SQLException{
		List<CartItems> cartItemList = new ArrayList<CartItems>();
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM "+cartName+";" ); 
		while ( rs.next() ) {
			CartItems items = new CartItems();
			items.setItemId(rs.getString("item_id"));
			items.setItemQuantity(Float.parseFloat(rs.getString("item_quantity")));;
			items.setItemPrice(Float.parseFloat(rs.getString("item_price")));
			cartItemList.add(items);
		}	         
		rs.close();
		stmt.close();

		c.close();
		return cartItemList;

	}
	public void updateCart(String cartName, CartItems cartItems) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		String sql = "UPDATE "+ cartName+" SET item_quantity = ?, item_price=? WHERE item_id = ?;";
		PreparedStatement pst = c.prepareStatement(sql) ;
		pst.setString(1, Double.toString(cartItems.getItemQuantity()));
		pst.setString(2, Double.toString(cartItems.getItemPrice()));
		pst.setString(3, cartItems.getItemId());
		pst.executeUpdate();
		pst.close();
		c.close();
	}

	public void insertToCart(Items item,String cartName,String quantity) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		String sql = "INSERT INTO "+ cartName+" (item_id,item_quantity,item_price) "
				+ "VALUES (?,?,?);";
		PreparedStatement pst = c.prepareStatement(sql) ;
		pst.setString(1, item.getItemId());
		pst.setString(2, quantity);
		pst.setString(3, Double.toString(item.getItemPrice()));
		
		pst.executeUpdate();

		pst.close();
		c.close();
	}
	public void insertDatatoItemTable(Items item) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		String sql = "INSERT INTO rtl_item (item_id,item_name,item_description,item_price,availability,item_image_id,shop_id) "
				+ "VALUES (?,?,?,?,?,?,?);";
		PreparedStatement pst = c.prepareStatement(sql) ;

		pst.setString(1, item.getItemId());
		pst.setString(2, item.getItemName());
		pst.setString(3, item.getItemDescription());
		pst.setString(4, Double.toString(item.getItemPrice()));
		pst.setString(5, item.getAvailability());
		pst.setString(6, item.getItemId());
		pst.setString(7, item.getShopId());
		pst.executeUpdate();

		pst.close();

		c.close();
	}
	public List<Items> fetchAllItems() throws SQLException{
		List<Items> itemList = new ArrayList<Items>();
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM rtl_item;" ); 
		while ( rs.next() ) {
			Items items = new Items();
			items.setItemId(rs.getString("item_id"));
			items.setAvailability(rs.getString("availability"));
			items.setItemDescription(rs.getString("item_description"));
			items.setItemImageId(rs.getString("item_image_id"));
			items.setItemName(rs.getString("item_name"));
			items.setItemPrice(Float.parseFloat(rs.getString("item_price")));
			items.setShopId(rs.getString("shop_id"));
			itemList.add(items);
		}	         
		rs.close();
		stmt.close();

		c.close();
		return itemList;

	}
}
