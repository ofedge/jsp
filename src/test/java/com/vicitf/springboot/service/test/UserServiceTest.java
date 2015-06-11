package com.vicitf.springboot.service.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springboot.ApplicationTest;
import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApplicationTest.class)
public class UserServiceTest {
	@Autowired
	private UserService us;
	
	@Test
	public void loginTest() {
		UserBean userBean = us.login("admin", "admin", "localhost");
		System.out.println(userBean.getId() + ", " + userBean.getUsername() + ", " + userBean.getAvatar());
	}
	
	@Test
	public void registerTest() {
		User user = new User("guest", "guest");
		System.out.println(us.register(user));
	}
	
	@Test
	public void existsByUsernameTest() {
		System.out.println(us.existsByUsername("admin"));
	}
	
	@Test
	public void updateProfileTest() {
		System.out.println(us.updateProfile("default.png", "administrator", "administrator@gmail.com", "male", 1L));
	}
	
	@Test
	public void updatePasswordTest() {
		System.out.println(us.updatePassword("admin", 1L, "admin"));
	}
	
	@Test
	public void verifyUserPasswordTest() {
		System.out.println(us.verifyUserPassword(1L, "admin", "admin"));
	}
}
