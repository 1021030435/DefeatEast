package com.app.base;

public class AppConfig {

	public static final Integer COED_SIZE = 4;

	public static final String CODE_SOURCES = "1234567890abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
	
	public static final String NUM_SOURCES = "1234567890";

	public static final Long JWT_EXPIRE_TIME = 1000 * 60 * 60 * 24L;

	public static final String JWT_MAP_KEY = "uId";

	public static final String JWT_RESPONSE = "Authorization";

	public static final String PHONE_PATTERN = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$";

	public static final String EMAIL_PATTERN = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+[\\\\.][a-zA-Z0-9_-]+$";
}
