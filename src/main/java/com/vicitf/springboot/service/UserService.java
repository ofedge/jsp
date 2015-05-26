package com.vicitf.springboot.service;

import com.vicitf.springboot.domain.primray.User;

public interface UserService {

	User login(String username, String password);

}