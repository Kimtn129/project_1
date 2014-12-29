package demo_struts2.connector;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLConnection {
	public static Connection getSQLConnection(String userName, String pass) {
		try {
			
			// Load mysql connector driver into DriverManager 
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Create a connection to sql server
			// syntax of string connection: jdbc:<database type>://<IP address>:<port>/<database name> 
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/demo_DB",
				userName,
				pass
			);
			return conn;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
		
		
	}
}
