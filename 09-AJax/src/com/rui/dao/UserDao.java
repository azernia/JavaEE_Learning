package com.rui.dao;

import java.util.List;

import com.rui.vo.Area;
import com.rui.vo.User;

public interface UserDao {
	User getUserInfo(String uname);
	
	List<Area> getAreaInfo(String pid);
}
