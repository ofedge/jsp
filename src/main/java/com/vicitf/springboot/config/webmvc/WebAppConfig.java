package com.vicitf.springboot.config.webmvc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Component
public class WebAppConfig extends WebMvcConfigurerAdapter {
	
	@Value("${springboot.app.openingtime}")
    private int openingTime;
	@Value("${springboot.app.closingtime}")
    private int closingTime;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new TimeBasedAccessInterceptor(openingTime, closingTime)).addPathPatterns("/*");
	}
}
