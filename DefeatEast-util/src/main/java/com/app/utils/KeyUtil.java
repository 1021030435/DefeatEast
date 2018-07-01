package com.app.utils;

import java.util.regex.Pattern;
import static com.app.base.AppConfig.*;

public class KeyUtil {

	public static Boolean isPhone(String phone) {
		String pattern = PHONE_PATTERN;
		return Pattern.matches(pattern, phone);
	}

	public static Boolean isEmail(String email) {
		String pattern = EMAIL_PATTERN;
		return Pattern.matches(pattern, email);
	}
}
