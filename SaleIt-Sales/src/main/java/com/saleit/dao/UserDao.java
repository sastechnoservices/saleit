package com.saleit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.saleit.domains.Address;
import com.saleit.domains.Name;
import com.saleit.domains.User;
import com.saleit.util.ConnectionClass;
import com.thoughtworks.xstream.XStream;

public class UserDao {
	public List<User> fetchAllUsers() throws SQLException{
		List<User> userList = new ArrayList<User>();
		Connection c = null;
		XStream xstream = new XStream();
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		Statement stmt = null;
		stmt = c.createStatement();
		ResultSet rs = stmt.executeQuery( "SELECT * FROM rtl_user;" ); 
		while (rs.next()) {
			User user = new User();
			user.setUserId(rs.getString("user_id"));
			user.setUserName((Name)xstream.fromXML(rs.getString("user_name")));
			user.setUserContactNumber(rs.getString("user_contact_number"));
			user.setUserEmailaddress(rs.getString("user_email_address"));
			user.setUserType(rs.getString("usertype"));
			user.setPassword(rs.getString("password"));
			user.setUserAddress((Address)xstream.fromXML(rs.getString("user_address")));
			userList.add(user);		
		}	         
		rs.close();
		stmt.close();

		c.close();
		return userList;
	}
	
	public void createUser(String userId, String password, String mobileNumber,String emailId) throws SQLException {
		Connection c = null;
		ConnectionClass connectionClass = new ConnectionClass();
		c = connectionClass.connectToDB();
		String sql = "INSERT INTO  rtl_user (user_id,user_name,user_contact_number,user_email_address,user_address,password,usertype); "
				+ "VALUES (?,?,?,?,?,?,?);";
		PreparedStatement pst = c.prepareStatement(sql) ;
		pst.setString(1, userId);
		pst.setString(2, " ");
		pst.setString(3, mobileNumber);
		pst.setString(4, " ");
		pst.setString(5, " ");
		pst.setString(6, password);
		pst.setString(6, "C");
		pst.executeUpdate();

		pst.close();
		c.close();
	}
}
