package com.sample.login.cookie;

import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.NewCookie;

public abstract class CookieUtil {

	public static NewCookie getCookie(String first, String second, boolean update) {
		if (update) {
			return new NewCookie(first, second, "/sample", null, 1, null, 0, false);
		}
		return new NewCookie("samplelogin", first + "|" + second + "|" + System.currentTimeMillis(), "/sample",
				null, 1, null, -1, false);
	}

	public static boolean isLogged(Cookie cookie, String username) {
		String user = cookie != null && !cookie.getValue().isEmpty() ? cookie.getValue() : "";
		return !user.isEmpty() && user.substring(0, user.indexOf("|")).equals(username);
	}
	
	public static String getUsername(Cookie cookie) {
		String user = cookie != null ? cookie.getValue() : "";
		return !user.isEmpty() && user.substring(0, user.indexOf("|")).length() > 0 ? user.substring(0, user.indexOf("|")) : "";
	}
}
