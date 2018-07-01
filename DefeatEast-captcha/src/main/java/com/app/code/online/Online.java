package com.app.code.online;

public interface Online {
	
	Integer SEND_SUCCESS = 0;
	
	Integer SEND_FAIL = 0;

	Integer send(String key, String code) throws Exception;
}
