package com.java1234.util;

/**
 * 字符串工具类
 * @author 安是老帅
 *
 */
public class StringUtil {
	/**
	 * 判断是否是空
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str==null||"".equals(str.trim())) { //trim（）去掉前后空格
			return true;
		}else {
			return false;
		}
	}
	
	/**
	 * 判断是否为非空
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		if (str!=null&& !"".equals(str.trim())) {
			return true;
		}else {
			return false;
		}
	}

}
