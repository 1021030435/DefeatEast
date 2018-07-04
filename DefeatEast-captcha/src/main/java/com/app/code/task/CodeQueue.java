package com.app.code.task;

import com.app.code.online.OnlineEnum;

public interface CodeQueue {

	void putTask(String key, String code, OnlineEnum onlineEnum) throws Exception;

	SendModel getTask();
	
}
