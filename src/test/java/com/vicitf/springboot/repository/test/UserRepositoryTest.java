package com.vicitf.springboot.repository.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.vicitf.springboot.Application;
import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class UserRepositoryTest {
	@Autowired
	private UserService us;
	
	@Test
	public void loginTest() {
		User user = us.login("admin", "admin");
		System.out.println(user.getId() + ", " + user.getUsername() + ", " + user.getPassword());
	}
}
