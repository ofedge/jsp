package com.vicitf.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.repository.primary.UserRepository;
import com.vicitf.springboot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User login(String username, String password) {
		User user = null;
		if (username != null && password != null) {
			user = userRepository.findByUsernameAndPassword(username, password);
		}
		return user;
	}
}
