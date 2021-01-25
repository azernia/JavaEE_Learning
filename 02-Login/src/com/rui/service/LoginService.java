package com.rui.service;

import com.rui.pojo.User;

public interface LoginService {
	User checkLogin(String uname, String pwd);
}
