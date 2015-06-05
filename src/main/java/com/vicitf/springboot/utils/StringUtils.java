package com.vicitf.springboot.utils;

public class StringUtils {
	/**
	 * 判断非空
	 * 
	 * @param strings
	 * @return
	 */
	public static boolean isNotNull(String...strings){
		for (String string : strings) {
			if(string == null || "".equals(string)) {
				return false;
			}
		}
		return true;
	}
}
