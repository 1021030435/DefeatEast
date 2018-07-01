package com.app.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.whalin.MemCached.MemCachedClient;

@Service
public class KeepCodeServiceImpl implements KeepCodeService {

	@Autowired
	private MemCachedClient memCachedClient;

	@Value("${code.expiry}")
	private Integer time;

	@Override
	public Boolean put(String key, String code) throws Exception {
		return memCachedClient.set(key, code, time);
	}

	@Override
	public String getCode(String key) throws Exception {
		return memCachedClient.get(key).toString();
	}

	@Override
	public Boolean delete(String key) throws Exception {
		return memCachedClient.delete(key);
	}

}
