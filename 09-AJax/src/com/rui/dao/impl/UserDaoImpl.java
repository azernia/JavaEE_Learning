package com.rui.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rui.dao.UserDao;
import com.rui.util.DBUtil;
import com.rui.vo.Area;
import com.rui.vo.User;

public class UserDaoImpl implements UserDao {

	@Override
	public User getUserInfo(String uname) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		String sql = "select * from users where uname = ?";
		conn = DBUtil.getMySQLConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			rs = ps.executeQuery();
			while(rs.next()) {
				u=new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPrice(rs.getDouble("price"));
				u.setLoc(rs.getString("loc"));
				u.setDesc(rs.getString("desc"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return u;
	}

	@Override
	public List<Area> getAreaInfo(String pid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Area> list = new ArrayList<>();
		String sql = "select * from area where parentid = ? order by areaid";
		conn = DBUtil.getMySQLConnection();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, pid);
			rs = ps.executeQuery();
			while(rs.next()) {
				Area area = new Area();
				area.setAreaid(rs.getInt("areaid"));
				area.setAreaname(rs.getString("areaname"));
				area.setParentid(rs.getInt("parentid"));
				list.add(area);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}

}
