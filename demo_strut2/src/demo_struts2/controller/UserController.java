package demo_struts2.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import demo.struts2.bean.UserBean;
import demo_struts2.connector.MySQLAdapter;

public class UserController {
	
	/*
	 * Function to get all of user in DB 
	 */
	public ArrayList<UserBean> getAllUser() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			String query = "SELECT * FROM users";
			ResultSet rs = (new MySQLAdapter()).execSelect(query);
			UserBean user = null;
			while (rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
}
