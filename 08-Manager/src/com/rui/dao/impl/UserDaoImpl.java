package com.rui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rui.dao.UserDao;
import com.rui.pojo.User;
import com.rui.util.DBUtil;

public class UserDaoImpl implements UserDao {
	@Override
	public User checkUserLoginDao(String uname, String pwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		String sql = "select * from t_user where uname = ? and pwd = ?";
		conn = DBUtil.getMySQLConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setObject(1, uname);
			ps.setObject(2, pwd);
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User(rs.getInt("uid"), rs.getString("uname"), rs.getString("pwd"), rs.getString("sex"),
						rs.getInt("age"), rs.getString("birthday"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return u;
	}

	@Override
	public int userChangePwdDao(String newPwd, int uid) {
		String sql = "update t_user set pwd = ? where uid = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		int index = 0;
		conn = DBUtil.getMySQLConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, newPwd);
			ps.setInt(2, uid);
			index = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return index;
	}

	@Override
	public List<User> showUserDao() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<User> list = new ArrayList<>();
		String sql = "select * from t_user";
		conn = DBUtil.getMySQLConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				User u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
				u.setSex(rs.getString("sex"));
				u.setAge(rs.getInt("age"));
				u.setBirthday(rs.getString("birthday"));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int userRegDao(User u) {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql="insert into t_user values(default,?,?,?,?,?)";
		conn = DBUtil.getMySQLConnection();
		int index = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getPwd());
			ps.setString(3, u.getSex());
			ps.setInt(4, u.getAge());
			ps.setString(5, u.getBirthday());
			index = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(ps, conn);
		}
		return index;
	}

}
