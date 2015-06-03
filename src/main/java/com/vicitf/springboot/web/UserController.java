package com.vicitf.springboot.web;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.service.UserService;

@Controller
public class UserController {
	
	@Value("${springboot.app.openingtime}")
    private int openingTime;
	@Value("${springboot.app.closingtime}")
    private int closingTime;
	
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
	
	@RequestMapping("/main")
	public String main(){
		return "main";
	}
	
	@RequestMapping("/outsideOfficeHour")
	public String outsideOfficeHour(HttpServletRequest request){
		request.setAttribute("openingTime", openingTime);
		request.setAttribute("closingTime", closingTime);
		return "outsideOfficeHour";
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public String login(String username, String password, HttpSession session) {
		User user = userService.login(username, password);
		if (user != null) {
			String loginUser = user.getUsername();
			session.setAttribute("loginUser", loginUser);
			Map<String, String> onlineUsers = (Map<String, String>) session.getServletContext().getAttribute(CommonParam.ONLINE_USERS);
			if (onlineUsers.containsKey(loginUser)) {
				System.out.println("-----" + loginUser + ": " + onlineUsers.get(loginUser) + " 被踢下线-----");
				onlineUsers.remove(loginUser);
			}
			onlineUsers.put(loginUser, session.getId());
			System.out.println("-----" + loginUser + "上线了-----");
			System.out.println("-----当前在线: " + onlineUsers.size() + "人-----");
			return "redirect:main";
		} else {
			return "redirect:index";
		}
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		String loginUser = (String) session.getAttribute("loginUser");
		session.invalidate();
		System.out.println("-----" + loginUser + "下线了------");
		return "redirect:index";
	}
}
