package com.vicitf.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vicitf.springboot.config.MyBanner;

@SpringBootApplication //相当于同事使用了@Configuration@EnableAutoConfiguration和@ComponentScan的默认配置
public class Application {
	public static void main(String[] args) {
//		SpringApplication.run(Application.class, args);
		SpringApplication app = new SpringApplication(Application.class);
		app.setBanner(new MyBanner());
		app.run(args);
	}
}