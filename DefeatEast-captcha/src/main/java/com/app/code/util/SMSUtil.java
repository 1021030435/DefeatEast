package com.app.code.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.code.config.SmsModel;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

@Component
public class SMSUtil {

	@Autowired
	private SmsModel model;

	public boolean send(String phoneNumber, String code) throws ApiException, IOException {
		TaobaoClient client = new DefaultTaobaoClient(model.getServerUrl(), model.getAppKey(), model.getAppSecret());
		AlibabaAliqinFcSmsNumSendRequest request = new AlibabaAliqinFcSmsNumSendRequest();
		request.setExtend(model.getExtend());
		request.setSmsType(model.getType());
		request.setSmsFreeSignName(model.getFreeSignName());
		request.setSmsParamString("{\"code\":\"" + code + "\"}");
		request.setRecNum(phoneNumber);
		request.setSmsTemplateCode(model.getTemplateCode());
		AlibabaAliqinFcSmsNumSendResponse response = client.execute(request);
		if (response.isSuccess()) {
			return true;
		}

		return false;
	}
	// {"alibaba_aliqin_fc_sms_num_send_response":{"result":{"err_code":"0","model":"181310825066081630^0","msg":"OK","success":true},"request_id":"zqbqjth6i9nb"}}
}
