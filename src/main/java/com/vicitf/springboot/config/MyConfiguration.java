package com.vicitf.springboot.config;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.vicitf.springboot.Application;
import com.vicitf.springboot.config.filter.LoginFilter;

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
			public void contextDestroyed(ServletContextEvent arg0) {
				System.out.println("-----contextDestroyed-----");
			}
			@Override
			public void contextInitialized(ServletContextEvent arg0) {
				System.out.println("-----contextInitialized-----");
			}
		};
	}
}
