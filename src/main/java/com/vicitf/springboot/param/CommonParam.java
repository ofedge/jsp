package com.vicitf.springboot.param;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用参数
 * 
 * @author vicitf
 *
 */
public class CommonParam {
	/**在线用户*/
	public static final String ONLINE_USERS = "onlineUsers";
	
	/** session中的当前user */
	public static final String SESSION_USER = "sessionUser";
	
	/** 过滤url列表 */
	public static final List<String> FILTER_LIST = new ArrayList<String>();
	
	/** 默认用户头像名称 */
	public static final String DEFAULT_AVATAR = "default.png";
}
