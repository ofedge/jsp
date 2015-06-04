package com.vicitf.springboot.service;

import com.vicitf.springboot.bean.UserBean;

public interface UserService {

	UserBean login(String username, String password);
	
	boolean register(String username, String password);

}