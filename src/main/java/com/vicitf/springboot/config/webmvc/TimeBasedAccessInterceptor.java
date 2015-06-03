package com.vicitf.springboot.config.webmvc;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 指定时间外拦截访问所有页面
 * 
 * @author vicitf
 *
 */
public class TimeBasedAccessInterceptor extends HandlerInterceptorAdapter {

    private int openingTime;
    private int closingTime;

    public TimeBasedAccessInterceptor(int openingTime, int closingTime) {
		this.openingTime = openingTime;
		this.closingTime = closingTime;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String uri = request.getRequestURI();
		Calendar cal = Calendar.getInstance();
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		if (openingTime <= hour && hour < closingTime) {
			if(uri.endsWith("outsideOfficeHour")){
				response.sendRedirect("/index");
				return false;
			}
			return true;
		} else {
			if(uri.endsWith("outsideOfficeHour"))
	    		return true;
			response.sendRedirect("/outsideOfficeHour");
			return false;
		}
    }
}