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
		System.out.println("-----I'm StartupListener.-----");
		System.out.println("-----You will not wish to cross me.-----");
		try {
			System.out.println("3...");
			Thread.sleep(100);
			System.out.println("2...");
			Thread.sleep(100);
			System.out.println("1...");
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
