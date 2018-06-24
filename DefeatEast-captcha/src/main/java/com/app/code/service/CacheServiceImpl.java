package com.app.code.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.code.db.mapper.CodeRecordMapper;
import com.app.code.db.model.CodeRecode;
import com.app.exception.CacheSMSCodeException;
import com.app.code.util.SMSUtil;
import com.whalin.MemCached.MemCachedClient;

@Service
public class CacheServiceImpl implements CacheService {

	@Autowired
	private MemCachedClient memCachedClient;

	@Autowired
	private CodeRecordMapper recordMapper;

	@Autowired
	private SMSUtil smsUtil;

	@Override
	public Boolean cacheCode(String key, String value, Date expiry) {
		try {
			return memCachedClient.set(key, value, expiry);
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public String getCacheCode(String key) {
		try {
			return (String) memCachedClient.get(key);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	@Transactional
	public void cacheSMSCode(String key, String value, Date expiry) {
		CodeRecode recode = new CodeRecode();
		recode.setSendTime(new Date());
		recode.setMsg(value);
		recode.setPhone(key);
		recordMapper.insert(recode);
		try {
			smsUtil.send(key, value);
		} catch (Exception e) {
			e.printStackTrace();
			throw new CacheSMSCodeException();
		}

		if (!memCachedClient.set(key, value, expiry)) {
			throw new CacheSMSCodeException();
		}
	}
}
