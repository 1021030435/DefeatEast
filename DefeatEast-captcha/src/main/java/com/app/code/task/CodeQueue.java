package com.app.code.task;

public interface CodeQueue {

	void putTask(String key, String code) throws Exception;

	SendModel getTask();
}
