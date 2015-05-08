package com.vicitf.springboot.config.Banner;

import java.io.PrintStream;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

/**
 * 自定义banner
 * 
 * @author vicitf
 *
 */
public class MyBanner implements Banner {
	private static final String[] BANNER = {
		"",
		"**************************",
		"--------------------------",
		"==========BANNER=========",
		"--------------------------",
		"**************************",
		""
	};

	@Override
	public void printBanner(Environment environment, Class<?> sourceClass,
			PrintStream out) {
		for (int i = 0; i < BANNER.length; i++) {
			out.print(BANNER[i]);
			out.println();
		}
	}
}
