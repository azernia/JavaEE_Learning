package com.rui.service.impl;

import com.rui.dao.LoginDao;
import com.rui.dao.impl.LoginDaoImpl;
import com.rui.pojo.User;
import com.rui.service.LoginService;

public class LoginServiceImpl implements LoginService {
	LoginDao ld = new LoginDaoImpl();
	@Override
	public User checkLogin(String uname, String pwd) {
		return ld.checkLogin(uname, pwd);
	}

}
