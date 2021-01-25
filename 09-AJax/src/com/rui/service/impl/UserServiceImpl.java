package com.rui.service.impl;

import java.util.List;

import com.rui.dao.UserDao;
import com.rui.dao.impl.UserDaoImpl;
import com.rui.service.UserService;
import com.rui.vo.Area;
import com.rui.vo.User;

public class UserServiceImpl implements UserService {
	UserDao ud = new UserDaoImpl();
	@Override
	public User getUserInfoService(String uname) {
		return ud.getUserInfo(uname);
	}

	@Override
	public List<Area> getAreaInfo(String pid) {
		return ud.getAreaInfo(pid);
	}

}
