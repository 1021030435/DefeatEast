package com.app.code.task;

import java.util.concurrent.LinkedBlockingQueue;
import org.springframework.stereotype.Component;

@Component
public class CodeQueueImpl implements CodeQueue {

	private static final LinkedBlockingQueue<SendModel> QUEUE = new LinkedBlockingQueue<SendModel>();

	@Override
	public void putTask(String key, String code) throws Exception {
		SendModel model = new SendModel();
		model.setKey(key);
		model.setCode(code);
		QUEUE.put(model);
	}

	@Override
	public SendModel getTask() {
		return QUEUE.poll();
	}
}
