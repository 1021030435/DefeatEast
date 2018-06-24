package com.app.code.util;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.app.code.model.SMSResponse;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.taobao.api.response.AlibabaAliqinFcSmsNumSendResponse;

@Component
public class SMSUtil {

	@Value("${sms.serverUrl}")
	private String serverUrl;

	@Value("${sms.appKey}")
	private String appKey;

	@Value("${sms.appSecret}")
	private String appSecret;

	@Value("${sms.extend}")
	private String extend;

	@Value("${sms.type}")
	private String type;

	@Value("${sms.freeSignName}")
	private String freeSignName;

	@Value("${sms.templateCode}")
	private String templateCode;

	public boolean send(String phoneNumber, String code) throws ApiException, JsonParseException, JsonMappingException, IOException {
		TaobaoClient client = new DefaultTaobaoClient(serverUrl, appKey, appSecret);
		AlibabaAliqinFcSmsNumSendRequest request = new AlibabaAliqinFcSmsNumSendRequest();
		request.setExtend(extend);
		request.setSmsType(type);
		request.setSmsFreeSignName(freeSignName);
		request.setSmsParamString("{\"code\":\"" + code + "\"}");
		request.setRecNum(phoneNumber);
		request.setSmsTemplateCode(templateCode);
		AlibabaAliqinFcSmsNumSendResponse response = client.execute(request);
		SMSResponse smsResponse = new ObjectMapper().readValue(response.getBody(), SMSResponse.class);
		if (smsResponse.getAlibaba_aliqin_fc_sms_num_send_response().getResult().getSuccess()) {
			return true;
		}

		return false;
	}
	// {"alibaba_aliqin_fc_sms_num_send_response":{"result":{"err_code":"0","model":"181310825066081630^0","msg":"OK","success":true},"request_id":"zqbqjth6i9nb"}}
}
