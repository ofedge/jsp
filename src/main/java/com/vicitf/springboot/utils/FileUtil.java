package com.vicitf.springboot.utils;

public class FileUtil {
	public static String getFileExt(String fileName) {
		if (StringUtils.isNotNull(fileName)) {
			if (fileName.indexOf(".") != -1) {
				String[] arr = fileName.split("\\.");
				return "." + arr[arr.length - 1];
			}
		}
		return "";
	}
}
