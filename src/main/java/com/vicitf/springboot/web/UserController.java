package com.vicitf.springboot.web;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicitf.springboot.domain.User;
import com.vicitf.springboot.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/")
	public String homePage(){
		return "redirect:index";
	}
	
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/person")
	public String person(){
		return "person";
	}
	
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		User user = userService.login(username, password);
		if (user != null) {
			String loginUser = user.getUsername();
			session.setAttribute("loginUser", loginUser);
			return "redirect:person";
		} else {
			return "redirect:index";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:index";
	}
}
