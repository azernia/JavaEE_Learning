package com.rui.dao;

import java.util.List;

import com.rui.pojo.User;

public interface UserDao {
	/**
	 * 根据用户名密码检验登录
	 * @param uname 用户名
	 * @param pwd 密码
	 * @return 返回查询到的用户信息
	 */
	User checkUserLoginDao(String uname, String pwd);
	/**
	 * 根据用户ID更改密码
	 * @param newPwd 新密码
	 * @param uid 用户ID
	 * @return 成功返回1，失败返回0
	 */
	int userChangePwdDao(String newPwd, int uid);
	/**
	 * 获取所有用户信息
	 * @return 返回用户集合
	 */
	List<User> showUserDao();
	/**
	 * 用户出册
	 * @param u 注册的用户对象
	 * @return 注册成功返回1,失败返回0
	 */
	int userRegDao(User u);
}
