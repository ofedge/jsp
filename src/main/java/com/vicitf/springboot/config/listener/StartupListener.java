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
	
	private void addFilterList() {
		CommonParam.filterList.add(".js");
		CommonParam.filterList.add(".css");
		CommonParam.filterList.add("index.jsp");
		CommonParam.filterList.add("/login");
		CommonParam.filterList.add("/index");
		CommonParam.filterList.add("/outsideOfficeHour");
		CommonParam.filterList.add("outsideOfficeHour.jsp");
	}

}
