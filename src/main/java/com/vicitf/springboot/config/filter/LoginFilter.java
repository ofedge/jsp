package com.vicitf.springboot.config.filter;

import java.io.IOException;
import java.util.Map;

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

import com.vicitf.springboot.param.CommonParam;
import com.vicitf.springboot.utils.CollectionUtils;

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

	@SuppressWarnings("unchecked")
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		String uri = request.getRequestURI();
		System.out.println(uri);
		if (CollectionUtils.containsSingle(uri, CommonParam.filterList)) {
			chain.doFilter(req, resp);
		} else {
			HttpSession session = request.getSession();
			String loginUser = (String) session.getAttribute("loginUser");
			if (loginUser == null) {
				response.sendRedirect("index");
			} else {
				Map<String, String> onlineUsers = (Map<String, String>) session.getServletContext().getAttribute(CommonParam.ONLINE_USERS);
				if (session.getId() != onlineUsers.get(loginUser)) {
					response.sendRedirect("index");
				} else {
					chain.doFilter(req, resp);
				}
			}
		}
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("-----LoginFilter init-----");
	}

}
