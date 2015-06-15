package com.vicitf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

import com.vicitf.springboot.config.banner.MyBanner;
import com.vicitf.springboot.config.listener.StartupListener;

/**
 * Main Class
 * 
 * @author vicitf
 *
 */
@SpringBootApplication //相当于同时使用了@Configuration@EnableAutoConfiguration和@ComponentScan的默认配置
public class Application extends SpringBootServletInitializer{ // 打包war文件需要继承SpringBootServletInitializer类
	
	public static void main(String[] args) {
		// jar方式运行时候使用
		SpringApplication app = new SpringApplication(Application.class);
		app.setBanner(new MyBanner());
		app.setShowBanner(false);
		app.addListeners(new StartupListener());
		app.run(args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		// tomcat运行会执行下面配置的条幅和监听, jar方式会运行main方法里设置的
		application.banner(new MyBanner()); // 条幅
		application.showBanner(true);
		application.listeners(new StartupListener()); //监听
    	return application.sources(Application.class);
	}
}