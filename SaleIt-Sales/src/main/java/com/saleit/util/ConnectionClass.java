package com.saleit.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionClass {
	
	public Connection connectToDB()
	{
		Connection c = null;
		try {
    	
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5432/saleIt",
           "postgres", "root");
     } catch (Exception e) {
        e.printStackTrace();
        System.err.println(e.getClass().getName()+": "+e.getMessage());
        System.exit(0);
     }
     return c;
  }
}
