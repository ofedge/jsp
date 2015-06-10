package com.vicitf.springboot.web;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.domain.primray.User;
import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.service.UserService;
import com.vicitf.springboot.utils.FileUtil;
import com.vicitf.springboot.utils.StringUtils;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/login")
	public String login(String username, String password) {
		String loginAddress = request.getRemoteAddr();
		UserBean userBean = userService.login(username, password, loginAddress);
		if (userBean != null) {
			Map<Long, String> onlineUsers = (Map<Long, String>) session.getServletContext().getAttribute(CommonParam.ONLINE_USERS);
			for (Long sessionUserId : onlineUsers.keySet()) {
				if (sessionUserId.equals(userBean.getId())) {
					log.info("-----" + userBean.getUsername() + ": " + onlineUsers.get(userBean.getId()) + " 在其他地方登陆, 原登陆被踢下线-----");
					onlineUsers.remove(sessionUserId);
				}
				if (session.getId().equals(onlineUsers.get(sessionUserId))) {
					UserBean oldSessionUser = (UserBean) session.getAttribute(CommonParam.SESSION_USER);
					log.info("-----由于 " + userBean.getUsername() + " 在本地登陆, " + oldSessionUser.getUsername() + ": " + session.getId() + " 已被迫下线-----");
					onlineUsers.remove(sessionUserId);
				}
			}
			onlineUsers.put(userBean.getId(), session.getId());
			session.setAttribute(CommonParam.SESSION_USER, userBean);
			log.info("-----" + userBean.getUsername() + ": " + session.getId() + " 上线了-----");
			log.info("-----当前在线: " + onlineUsers.size() + " 人-----");
			return "redirect:/main";
		} else {
			return "redirect:/";
		}
	}
	
	@RequestMapping("/logout")
	public String logout() {
		UserBean userBean = (UserBean) session.getAttribute(CommonParam.SESSION_USER);
		session.invalidate();
		log.info("-----" + userBean.getUsername() + "下线了------");
		return "redirect:/";
	}
	
	@RequestMapping("/existsUser")
	@ResponseBody
	public boolean existsUser(String username) {
		if(StringUtils.isNotNull(username)) {
			if(userService.existsByUsername(username))
				return true;
		}
		return false;
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(String username, String password){
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
	
	@RequestMapping(value = "updateProfile", method = RequestMethod.POST)
	public String updateProfile(@RequestParam(value = "avatar") MultipartFile avatar, String realname, String email, String gender) {
		String avatarName = "";
		UserBean sessionUser = (UserBean)session.getAttribute(CommonParam.SESSION_USER);
		if (avatar.getSize() > 0L) {
			avatarName = String.valueOf(System.currentTimeMillis()) + FileUtil.getFileExt(avatar.getOriginalFilename());
			String dir = servletContext.getRealPath("/avatar");
			File uploadFile = new File(dir, avatarName);
			try {
				FileUtils.writeByteArrayToFile(uploadFile, avatar.getBytes());
				log.info("用户 " + sessionUser.getUsername() + " 头像 " + avatarName + " 已上传");
				File oldAvatar = new File(dir, sessionUser.getAvatar());
				if (oldAvatar.isFile() && oldAvatar.exists()) {
					oldAvatar.delete();
					log.info("删除 " + sessionUser.getUsername() + " 的旧头像文件: " + oldAvatar.getAbsolutePath());
				}
			} catch (IOException e) {
				log.error("用户 " + sessionUser.getUsername() + " 头像上传异常");
				avatarName = sessionUser.getAvatar();
				e.printStackTrace();
			}
		} else {
			avatarName = sessionUser.getAvatar();
		}
		if (userService.updateProfile(avatarName, realname, email, gender, sessionUser.getId())) {
			sessionUser.setAvatar(avatarName);
			sessionUser.setRealname(realname);
			sessionUser.setEmail(email);
			sessionUser.setGender(gender);
			session.setAttribute(CommonParam.SESSION_USER, sessionUser);
		}
		return "redirect:/user";
	}
}
