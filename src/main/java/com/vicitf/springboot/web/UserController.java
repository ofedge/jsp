package com.vicitf.springboot.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.service.UserService;
import com.vicitf.springboot.utils.StringUtils;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session, HttpServletRequest request) {
		String loginAddress = request.getRemoteAddr();
		UserBean userBean = userService.login(username, password, loginAddress);
		if (userBean != null) {
			Map<Long, String> onlineUsers = (Map<Long, String>) session.getServletContext().getAttribute(CommonParam.ONLINE_USERS);
			for (Long sessionUserId : onlineUsers.keySet()) {
				if (sessionUserId.equals(userBean.getId())) {
					System.out.println("-----" + userBean.getUsername() + ": " + onlineUsers.get(userBean.getId()) + " 在其他地方登陆, 原登陆被踢下线-----");
					onlineUsers.remove(sessionUserId);
				}
				if (onlineUsers.get(sessionUserId).equals(session.getId())) {
					UserBean oldSessionUser = (UserBean) session.getAttribute(CommonParam.SESSION_USER);
					System.out.println("-----由于 " + userBean.getUsername() + " 在本地登陆, " + oldSessionUser.getUsername() + ": " + session.getId() + " 已被迫下线-----");
					onlineUsers.remove(sessionUserId);
				}
			}
			onlineUsers.put(userBean.getId(), session.getId());
			session.setAttribute(CommonParam.SESSION_USER, userBean);
			System.out.println("-----" + userBean.getUsername() + ": " + session.getId() + " 上线了-----");
			System.out.println("-----当前在线: " + onlineUsers.size() + " 人-----");
			return "redirect:/main";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		UserBean userBean = (UserBean) session.getAttribute(CommonParam.SESSION_USER);
		session.invalidate();
		System.out.println("-----" + userBean.getUsername() + "下线了------");
		return "redirect:/";
	}
	
	@RequestMapping("/existsUser")
	@ResponseBody
	public String existsUser(String username) {
		if(StringUtils.isNotNull(username)) {
			if(userService.existsByUsername(username))
				return "Y";
		}
		return "N";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String username, String password, HttpServletRequest request){
		if(StringUtils.isNotNull(username, password)){
			User user = new User(username, password);
			String loginAddress = request.getRemoteAddr();
			user.setLoginAddress(loginAddress);
			if(userService.register(user)){
				return "redirect:/";
			}
		}
		return "/signup";
	}
}
