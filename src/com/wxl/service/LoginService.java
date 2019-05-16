package com.wxl.service;

import com.wxl.bean.User;
import com.wxl.dao.UserDao;

public class LoginService {
	public User queryByName(String name){
		User user = new User();
		UserDao dao = new UserDao();
		user = dao.queryName(name);
		return user;
	}
}
