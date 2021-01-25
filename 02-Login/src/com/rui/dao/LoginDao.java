package com.rui.dao;

import com.rui.pojo.User;

public interface LoginDao {
	User checkLogin(String uname, String pwd);
}
