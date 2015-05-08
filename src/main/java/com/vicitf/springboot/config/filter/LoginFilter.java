package com.vicitf.springboot.config.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

/**
 * 我想要一个登陆过滤, 在stackoverflow看到有人说继承Filter, 之后有人评论, 
 * "You deserve an upvote just for your filter implementation. May he live in the clacks forever!"
 * 
 * @author vicitf
 *
 */
@Component
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("-----LoginFilter destroy-----");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		HttpSession session = request.getSession();
		String loginUser = (String) session.getAttribute("loginUser");
		if (loginUser == null && !uri.endsWith(".js") && !uri.endsWith(".css") && !uri.endsWith("index.jsp") && !uri.endsWith("login") && !uri.endsWith("index")) {
			response.sendRedirect("index");
		} else {
			chain.doFilter(req, resp);
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("-----LoginFilter init-----");
	}

}
