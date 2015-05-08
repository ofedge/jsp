package com.vicitf.springboot.config.listener;

import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;

/**
 * This is not what I want...
 * 
 * @author vicitf
 *
 */
public class StartupListener implements ApplicationListener<ApplicationStartedEvent> {

	@Override
	public void onApplicationEvent(ApplicationStartedEvent event) {
		event.getSpringApplication();
		System.out.println("-----I'm StartupListener.-----");
	}

}
