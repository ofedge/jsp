package com.vicitf.springboot.config;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vicitf.springboot.Application;
import com.vicitf.springboot.config.filter.LoginFilter;
import com.vicitf.springboot.param.CommonParam;

/**
 * Configruation
 * 写在{@link Application}或者{@link CacheConfiguration}里也行
 * 
 * @author vicitf
 *
 */
@Configuration
public class MyConfiguration {
	// 把LoginFilter注册上, 了却一块心病, 虽然没有这个也能工作...
	@Bean
	public FilterRegistrationBean registration(LoginFilter filter) {
		FilterRegistrationBean bean = new FilterRegistrationBean(filter);
		bean.setEnabled(true);
		return bean;
	}
	
	// 这才是我想要的listener
	@Bean
	public ServletContextListener listener() {
		return new ServletContextListener() {
			@Override
			public void contextInitialized(ServletContextEvent event) {
				System.out.println("-----contextInitialized-----");
				ServletContext context = event.getServletContext();
				Map<String, String> onlineUser = new HashMap<String, String>();
				context.setAttribute(CommonParam.ONLINE_USERS, onlineUser);
			}
			@Override
			public void contextDestroyed(ServletContextEvent event) {
				System.out.println("-----contextDestroyed-----");
			}
		};
	}
}
