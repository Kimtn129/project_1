package demo_struts2.connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLAdapter {

	protected static final String SQL_USER = "root";
	protected static final String SQL_PASSWORD = "admin";

	// Get connection to MySQL server with user/password: "root"/"admin"
	protected Connection conn = MySQLConnection.getSQLConnection("root", "admin");
	
	public ResultSet execSelect(String tableName, String ... whereClause) throws SQLException {
		Statement sttm = conn.createStatement();
		String query = "SELECT * FROM " + tableName;
		if (whereClause.length > 0) {
			query += " WHERE ";
			for (String string : whereClause) {
				query += string + " AND ";
			}
			query += " 1=1";
		}
		return sttm.executeQuery(query);
	}
	
	public int execInsert(String tableName, String[] values) throws SQLException {
		Statement sttm = conn.createStatement();
		return sttm.executeUpdate("INSERT INTO " + tableName + " VALUES (" + values.toString() + ")");
	}
}
