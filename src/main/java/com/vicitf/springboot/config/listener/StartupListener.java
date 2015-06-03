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
	 * 好像js和css不用添加进去也行啊..
	 */
	private void addFilterList() {
		System.out.println("初始化过滤请求");
		CommonParam.filterList.add(".js");
		CommonParam.filterList.add(".css");
		CommonParam.filterList.add("index.jsp");
		CommonParam.filterList.add("/login");
		CommonParam.filterList.add("/index");
		CommonParam.filterList.add("/outsideOfficeHour");
		CommonParam.filterList.add("outsideOfficeHour.jsp");
	}

}
