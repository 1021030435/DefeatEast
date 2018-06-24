package com.app.code.service;

import java.util.Date;

public interface CacheService {

	Boolean cacheCode(String key, String value, Date expiry);

	void cacheSMSCode(String key, String value, Date expiry);

	String getCacheCode(String key);
}
