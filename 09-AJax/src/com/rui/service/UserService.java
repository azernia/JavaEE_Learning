package com.rui.service;

import java.util.List;

import com.rui.vo.Area;
import com.rui.vo.User;

public interface UserService {
	User getUserInfoService(String uname);
	List<Area> getAreaInfo(String pid);
}
