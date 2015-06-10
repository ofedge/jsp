package com.vicitf.springboot.service;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.domain.primray.User;

public interface UserService {

	/**
	 * 登陆
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	UserBean login(String username, String password, String loginAddress);
	
	/**
	 * 注册
	 * 
	 * @param user
	 * @return
	 */
	boolean register(User user);

	/**
	 * 用户名是否存在
	 * 
	 * @param username
	 * @return
	 */
	boolean existsByUsername(String username);
	
	
}