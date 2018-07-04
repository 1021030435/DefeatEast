package com.app.code.task;

import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Component;

import com.app.code.online.OnlineEnum;

@Component
public class CodeQueueImpl implements CodeQueue {

	private static final LinkedBlockingQueue<SendModel> QUEUE = new LinkedBlockingQueue<SendModel>();

	@Override
	public void putTask(String key, String code, OnlineEnum onlineEnum) throws Exception {
		SendModel model = new SendModel();
		model.setKey(key);
		model.setCode(code);
		model.setOnlineEnum(onlineEnum);
		QUEUE.put(model);
	}

	@Override
	public SendModel getTask() {
		return QUEUE.poll();
	}
	
}
