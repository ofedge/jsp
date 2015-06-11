package com.vicitf.springboot.web;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vicitf.springboot.bean.UserBean;
import com.vicitf.springboot.param.CommonParam;

public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
	@Autowired
	protected ServletContext servletContext;
	
	protected Log log = LogFactory.getLog(getClass());
	
	protected UserBean getSessionUser(){
		return (UserBean) session.getAttribute(CommonParam.SESSION_USER);
	}
}
