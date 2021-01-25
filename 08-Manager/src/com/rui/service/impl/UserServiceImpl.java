package com.rui.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import com.rui.dao.UserDao;
import com.rui.dao.impl.UserDaoImpl;
import com.rui.pojo.User;
import com.rui.service.UserService;

public class UserServiceImpl implements UserService {
	Logger logger = Logger.getLogger(UserServiceImpl.class);
	private UserDao ud = new UserDaoImpl();
	@Override
	public User checkUserLoginService(String uname, String pwd) {
		//打印日志
		logger.debug(uname + "发起请求");
		User u = ud.checkUserLoginDao(uname, pwd);
		if(u != null) {
			logger.debug(uname + "Login success");
		} else {
			logger.debug(uname + "Login fail");
		}
		return u;
	}

	@Override
	public int userChangePwdService(String newPwd, int uid) {
		logger.debug(uid + ":发起密码修改请求");
		int index = ud.userChangePwdDao(newPwd, uid);
		if(index > 0) {
			logger.debug(uid + ":密码修改成功");
		} else {
			logger.debug(uid + ":密码修改失败");
		}
		return index;
	}

	@Override
	public List<User> userShowService() {
		List<User> list = ud.showUserDao();
		logger.debug("显示所有用户信息:" + list);
		return list;
	}

	@Override
	public int userRegService(User u) {
		logger.debug(u.getUname() + ":提交注册申请");
		int index = ud.userRegDao(u);
		if(index > 0) {
			logger.debug(u.getUname() + ":注册成功");
		} else {
			logger.debug(u.getUname() + ":注册失败");
		}
		return index;
	}

}
