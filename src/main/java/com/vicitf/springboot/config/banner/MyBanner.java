package com.vicitf.springboot.config.banner;

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
		"      V      i  c   i    t       f",
		"  __     __  _      _    _       __      ",
		"  \\ \\    / /(_)_ _ (_)__| |__ __/ /_   ",
		"   \\ \\  / / | | / /| |__| |__|_  __|   ",
		"    \\ \\/ /  | || | | |  | |    | |     ",
		"     \\__/___| |_\\ \\| |___\\ \\___| |_ ",
		"  ============================/ /=====  "
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
