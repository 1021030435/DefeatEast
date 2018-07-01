package com.app.code.online;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.code.service.CodeRecordService;

import static com.app.utils.KeyUtil.*;

@Component
public class OnlineFactory {

	@Autowired
	private SMSOnline sms;

	@Autowired
	private EmailOnline email;
	
	@Autowired
	private CodeRecordService recordService;
	
	public void send(String key, String code) throws Exception {
		Integer result = null;
		if (isPhone(key)) {
			result = new OnlineSend(sms).send(key, code);
			recordService.insertPhone(key, code, result);
			return;
		}
		
		if (isEmail(key)) {
			result = new OnlineSend(email).send(key, code);
			recordService.insertEmail(key, code, result);
			return;
		}
		
	}
}
