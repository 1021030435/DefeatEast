package com.app.base;

public class AppConfig {
	
	public static final Integer COED_SIZE= 4; 
	
	public static final String CODE_SOURCES = "1234567890abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
	
	public static final Long COED_IMG_EXPIRY= 30 * 1000L;
	
	public static final Long COED_EXPIRY= 60 * 1000L;
	
	public static final Long JWT_EXPIRE_TIME = 1000 * 60 * 60 * 24L;
	
	public static final String JWT_MAP_KEY = "uId";
	
	public static final String JWT_RESPONSE = "Authorization";
}
