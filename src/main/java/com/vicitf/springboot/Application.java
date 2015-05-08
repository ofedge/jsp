package com.vicitf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vicitf.springboot.config.Banner.MyBanner;
import com.vicitf.springboot.config.listener.StartupListener;

/**
 * Main Class
 * 
 * @author vicitf
 *
 */
@SpringBootApplication //相当于同时使用了@Configuration@EnableAutoConfiguration和@ComponentScan的默认配置
public class Application {
	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		app.setBanner(new MyBanner()); // 条幅
		app.addListeners(new StartupListener()); // 监听
		app.run(args);
	}
}