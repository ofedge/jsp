package com.vicitf.springboot.config.webmvc;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.http.HttpStatus;

/**
 * 打包war情况下, 貌似端口设置是没用的...
 * 
 * @author vicitf
 *
 */
public class CustomizationBean implements EmbeddedServletContainerCustomizer {
	
	public static final int PORT = 8014; // 端口
	public static final int SESSION_TIME_OUT = 30; // session过期时间

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        container.setPort(PORT);
        container.setSessionTimeout(SESSION_TIME_OUT, TimeUnit.MINUTES);
        container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"));
        container.addErrorPages(new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
    }

}