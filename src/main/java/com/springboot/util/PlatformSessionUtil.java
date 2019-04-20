package com.springboot.util;

import javax.servlet.http.HttpServletRequest;

public class PlatformSessionUtil {

	public static Object getSession(HttpServletRequest request) {
		return request.getSession();
	}
}
