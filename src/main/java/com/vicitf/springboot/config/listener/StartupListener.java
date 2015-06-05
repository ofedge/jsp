package com.vicitf.springboot.config.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

import com.vicitf.springboot.param.CommonParam;

/**
 * startup listener
 * 
 * @author vicitf
 *
 */
public class StartupListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		addFilterList();
	}
	
	/**
	 * 过滤url列表
	 */
	private void addFilterList() {
		CommonParam.FILTER_LIST.add(".js");
		CommonParam.FILTER_LIST.add(".css");
		CommonParam.FILTER_LIST.add("/");
		CommonParam.FILTER_LIST.add("/login");
		CommonParam.FILTER_LIST.add("/signup");
		CommonParam.FILTER_LIST.add("/signin");
		CommonParam.FILTER_LIST.add("/existsUser");
		CommonParam.FILTER_LIST.add("/register");
		CommonParam.FILTER_LIST.add("/outsideOfficeHour");
		CommonParam.FILTER_LIST.add("signin.jsp");
		CommonParam.FILTER_LIST.add("signup.jsp");
		CommonParam.FILTER_LIST.add("outsideOfficeHour.jsp");
	}

}
