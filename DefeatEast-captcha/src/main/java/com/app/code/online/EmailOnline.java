package com.app.code.online;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import com.app.code.config.EmailModel;

@OnlineType(type = OnlineEnum.EMAIL)
public class EmailOnline implements Online {

	@Autowired
	private EmailModel model;

	public Integer send(String key, String code) throws Exception {
		try {
			HtmlEmail email = new HtmlEmail();
			email.setHostName(model.getHostName());
			email.setCharset("UTF-8");
			email.addTo(key);
			email.setFrom(model.getFrom());
			email.setAuthentication(model.getFrom(), model.getPsw());
			email.setSubject("欢迎使用XXX购物平台");
			email.setMsg("您的验证码是:" + code);
			String result = email.send();
			System.out.println(result);
		} catch (Exception e) {
			return SEND_FAIL;
		}

		return SEND_SUCCESS;
	}
	
}