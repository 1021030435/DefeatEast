package com.app.utils;

import java.util.regex.Pattern;

public class KeyUtil {

	public static Boolean isPhone(String phone) {
		String pattern = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";
		return Pattern.matches(pattern, phone);
	}

	public static Boolean isEmail(String email) {
		String pattern = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+[\\.][a-zA-Z0-9_-]+$";
		return Pattern.matches(pattern, email);
	}
}
