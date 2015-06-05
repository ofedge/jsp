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
		UserBean userBean = (UserBean) session.getAttribute(CommonParam.SESSION_USER);
		session.invalidate();
		System.out.println("-----" + userBean.getUsername() + "下线了------");
		return "redirect:/";
	}
	
	@RequestMapping("/existsUser")
	@ResponseBody
	public String existsUser(String username){
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
