package com.app.code.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.app.code.online.OnlineFactory;
import com.app.code.service.KeepCodeService;

@Component
public class SendTask {

	@Autowired
	private CodeQueue queue;

	@Autowired
	private KeepCodeService codeService;

	@Autowired
	private OnlineFactory factory;

	@Scheduled(cron = "${send.corn}")
	public void send() {
		SendModel model = queue.getTask();
		if (model == null) {
			return;
		}

		try {
			Boolean seccess = codeService.put(model.getKey(), model.getCode());
			if (!seccess) {
				return;
			}

			factory.send(model.getKey(), model.getCode());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
