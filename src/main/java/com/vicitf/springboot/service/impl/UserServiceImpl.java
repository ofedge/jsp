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
	public UserBean login(String username, String password, String loginAddress) {
		UserBean userBean = null;
		if (username != null && password != null) {
			User user = userRepository.findByUsernameAndPassword(username, password);
			if (user != null) {
				Long id = user.getId();
				userBean = new UserBean();
				userBean.setId(id);
				userBean.setUsername(user.getUsername());
				userBean.setRealname(user.getRealname());
				userBean.setGender(user.getGender());
				userBean.setEmail(user.getEmail());
				userBean.setAvatar(user.getAvatar());
				userRepository.updateLoginAddress(loginAddress, id);
			}
		}
		return userBean;
	}

	@Override
	public boolean register(User user) {
		user.setAvatar(CommonParam.DEFAULT_AVATAR);
		userRepository.save(user);
		return user.getId() != null;
	}

	@Override
	public boolean existsByUsername(String username) {
		return userRepository.existsByUsername(username) > 0;
	}

	@Override
	public boolean updateProfile(String avatar, String realname, String email, String gender, Long id) {
		return userRepository.updateProfile(avatar, realname, email, gender, id) > 0;
	}

	@Override
	public boolean updatePassword(String password, Long id, String username) {
		return userRepository.updatePassword(password, id, username) > 0;
	}

	@Override
	public boolean verifyUserPassword(Long id, String username, String password) {
		return userRepository.verifyUserPassword(id, username, password) > 0;
	}
}
