package com.vicitf.springboot.utils;

import java.util.List;

public class CollectionUtils {
	
	/**
	 * 如果字符串str是以list里任何一个元素结尾则返回true
	 * 
	 * @param str
	 * @param list
	 * @return
	 */
	public static boolean containsSingle(String str, List<String> list) {
		for (String s : list) {
			if(str.endsWith(s))
				return true;
		}
		return false;
	}
}
