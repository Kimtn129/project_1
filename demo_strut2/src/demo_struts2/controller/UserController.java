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
	public static ArrayList<UserBean> getAllUser() {
		ArrayList<UserBean> users = new ArrayList<UserBean>();
		try {
			ResultSet rs = (new MySQLAdapter()).execSelect("users");
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
	
	/*
	 * Function to get a user from email and password
	 */
	public static UserBean getUser(String email, String password) {
		UserBean user = null;
		try {
			ResultSet rs = (new MySQLAdapter()).execSelect("users", new String[]{"email = '" + email + "'", "password = '" + password + "'"});
			while (rs.next()) {
				user = new UserBean();
				user.setEmail(rs.getString(2));
				user.setPassword(rs.getString(3));
				user.setFirstName(rs.getString(4));
				user.setLastName(rs.getString(5));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
}
