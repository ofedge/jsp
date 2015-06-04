package com.vicitf.springboot.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.service.UserService;
import com.vicitf.springboot.utils.StringUtils;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("register")
	public String register(String username, String password, HttpServletRequest request){
		if(StringUtils.isNotNull(username, password)){
			if(userService.register(username, password)){
				return "redirect:/signin";
			}
		}
		request.setAttribute("msg", "Error, please try again!");
		return "redirect:/signup";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		UserBean userBean = userService.login(username, password);
		if (userBean != null) {
			session.setAttribute(CommonParam.SESSION_USER, userBean);
			Map<Long, String> onlineUsers = (Map<Long, String>) session.getServletContext().getAttribute(CommonParam.ONLINE_USERS);
			if (onlineUsers.containsKey(userBean.getId())) {
				System.out.println("-----" + userBean.getUsername() + ": " + onlineUsers.get(userBean.getId()) + " 被踢下线-----");
				onlineUsers.remove(userBean.getId());
			}
			onlineUsers.put(userBean.getId(), session.getId());
			System.out.println("-----" + userBean.getUsername() + "上线了-----");
			System.out.println("-----当前在线: " + onlineUsers.size() + "人-----");
			return "redirect:/main";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		session.invalidate();
		System.out.println("-----" + loginUser + "下线了------");
		return "redirect:/";
	}
}
