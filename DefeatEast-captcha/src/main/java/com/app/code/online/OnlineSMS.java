package com.app.code.online;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.code.config.SmsModel;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

@Component
public class OnlineSMS implements Online {

	@Autowired
	private SmsModel model;

	public Integer send(String key, String code) throws Exception {
		TaobaoClient client = new DefaultTaobaoClient(model.getServerUrl(), model.getAppKey(), model.getAppSecret());
		AlibabaAliqinFcSmsNumSendRequest request = new AlibabaAliqinFcSmsNumSendRequest();
		request.setExtend(model.getExtend());
		request.setSmsType(model.getType());
		request.setSmsFreeSignName(model.getFreeSignName());
		request.setSmsParamString("{\"code\":\"" + code + "\"}");
		request.setRecNum(key);
		request.setSmsTemplateCode(model.getTemplateCode());
		AlibabaAliqinFcSmsNumSendResponse response = client.execute(request);
		return response.isSuccess() ? SEND_SUCCESS : SEND_FINAL;
	}
}
