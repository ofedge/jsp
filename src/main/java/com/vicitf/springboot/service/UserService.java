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
	
	/**
	 * 更新个人信息
	 * 
	 * @param avatar
	 * @param realname
	 * @param email
	 * @param female
	 * @param id
	 * @return
	 */
	boolean updateProfile(String avatar, String realname, String email, String gender, Long id);
	
	/**
	 * 修改密码
	 * 
	 * @param password
	 * @param id
	 * @param username
	 * @return
	 */
	boolean updatePassword(String password, Long id, String username);
	
	/**
	 * 验证密码
	 * 
	 * @param id
	 * @param username
	 * @param password
	 * @return
	 */
	boolean verifyUserPassword(Long id, String username, String password);
}