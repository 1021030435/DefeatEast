package com.app.controller.base;

public class AppConfig {
	
	public static final Integer COED_SIZE= 4; 
	
	public static final String CODE_SOURCES = "1234567890abcdefghjklmnpqrstuvwxyzABCDEFGHJKLMNPQRSTUVWXYZ";
	
	public static final Long COED_IMG_EXPIRY= 30 * 1000L;
	
	public static final Long COED_EXPIRY= 60 * 1000L;
	
	public static final Long JWT_EXPIRE_TIME = 1000 * 60 * 60 * 24L;
	
	public static final String JWT_MAP_KEY = "uId";
	
	public static final String JWT_RESPONSE = "Authorization";
	
	public static final Integer SUCCESS = 1000;
	
	public static final Integer SYSTEM_ERROR = 1002;
	
	public static final Integer VALIDATE_ERROR = 1003;
	
	public static final Integer CODE_EXIST_ERROR = 1004;
	
	public static final Integer PHONE_ERROR = 1005;
	
	public static final Integer EMAIL_ERROR = 1006;
	
	public static final Integer CACHE_ERROR = 1007;
	
	public static final Integer FREQUENCY_ERROR = 1008;
	
	public static final Integer SIGNIN_ERROR = 1009;
	
	public static final Integer USER_ERROR = 1010;
	
	public static final Integer PSW_ERROR = 1012;
	
	public static final Integer KEY_ERROR = 1013;
	
	public static final Integer Param_ERROR = 1014;
	
	public static final String SUCCESS_MSG = "操作成功";
}
