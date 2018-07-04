package com.app.code.online;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import com.app.code.service.CodeRecordService;
import com.app.code.task.SendModel;

@Component
public class OnlineFactory {

	@Autowired
	private ApplicationContext context;

	@Autowired
	private CodeRecordService recordService;

	public void send(SendModel model) throws Exception {
		Map<String, Object> map = context.getBeansWithAnnotation(OnlineType.class);
		Iterator<Entry<String, Object>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			@SuppressWarnings("unchecked")
			Class<Online> clazz = (Class<Online>) iterator.next().getValue().getClass();
			OnlineEnum onlineEnum = clazz.getAnnotation(OnlineType.class).type();
			if (!model.getOnlineEnum().equals(onlineEnum)) {
				continue;
			}

			Integer success = new OnlineSend(context.getBean(clazz)).send(model.getKey(), model.getCode());
			recordService.insert(model.getOnlineEnum().getType(), model.getKey(), model.getCode(), success);
			break;
		}
	}
	
}
