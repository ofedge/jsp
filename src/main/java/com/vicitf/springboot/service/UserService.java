package com.vicitf.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.repository.primary.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User login(String username, String password) {
		User user = null;
		if (username != null && password != null) {
			user = userRepository.findByUsernameAndPassword(username, password);
		}
		return user;
	}
}
