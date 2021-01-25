package com.rui.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.rui.dao.LoginDao;
import com.rui.pojo.User;

public class LoginDaoImpl implements LoginDao {

	@Override
	public User checkLogin(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletdemo?serverTimezone=UTC", "root", "capslock");
			String sql = "select * from t_user where uname = ? and pwd = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, uname);
			ps.setObject(2, pwd);
			rs = ps.executeQuery();
			if(rs.next()) {
				u = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("pwd"));
				return u;
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}

}
