package com.vicitf.springboot.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Value("${springboot.app.openingtime}")
	private int openingTime;
	@Value("${springboot.app.closingtime}")
	private int closingTime;

	@RequestMapping("/")
	public String homePage() {
		return "signin";
	}

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}

	@RequestMapping("/signin")
	public String signin() {
		return "signin";
	}

	@RequestMapping("/outsideOfficeHour")
	public String outsideOfficeHour(HttpServletRequest request) {
		request.setAttribute("openingTime", openingTime);
		request.setAttribute("closingTime", closingTime);
		return "outsideOfficeHour";
	}

	@RequestMapping("/person")
	public String person() {
		return "person";
	}
	
	@RequestMapping("/country")
	public String country() {
		return "country";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "user";
	}
}
