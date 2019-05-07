package com.zhang.student.utils;

public class StringUtils {
	/**
	 * 判断字符是否为空
	 * @param string
	 * @return
	 */
	public static boolean isEmpty(String string) {
		if (string==null) {
			return true;
		}
		if(string.trim().length()==0)
		{
			return true;
		}
		return false;
	}
	/**
	 * 判断字符串不为空
	 * @param string
	 * @return
	 */
	public static boolean isNotEmpty(String string)
	{
		return isEmpty(string)?false:true;
	}
}
