package com.vicitf.springboot.service;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.domain.primray.User;

public interface UserService {

	UserBean login(String username, String password);
	
	boolean register(User user);

	boolean existsByUsername(String username);
}