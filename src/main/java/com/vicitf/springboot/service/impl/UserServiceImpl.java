package com.vicitf.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.repository.primary.UserRepository;
import com.vicitf.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserBean login(String username, String password) {
		UserBean userBean = null;
		if (username != null && password != null) {
			User user = userRepository.findByUsernameAndPassword(username, password);
			userBean = new UserBean();
			userBean.setId(user.getId());
			userBean.setUsername(user.getUsername());
			userBean.setAvatar(user.getAvatar());
		}
		return userBean;
	}

	@Override
	public boolean register(String username, String password) {
		User user = new User(username, password);
		user.setAvatar(CommonParam.DEFAULT_AVATAR);
		userRepository.save(user);
		return user.getId() != null;
	}
}
