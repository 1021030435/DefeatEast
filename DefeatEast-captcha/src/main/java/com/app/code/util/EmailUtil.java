package com.app.code.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.app.code.config.EmailModel;

@Component
public class EmailUtil {

	@Autowired
	private EmailModel model;

	public boolean sendEmail(String emailaddress, String code) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName(model.getHostName());
		email.setCharset("UTF-8");
		email.addTo(emailaddress);
		email.setFrom(model.getFrom());
		email.setAuthentication(model.getFrom(), model.getPsw());
		email.setSubject("欢迎使用XXX购物平台");
		email.setMsg("您的验证码是:" + code);
		email.send();
		return true;
	}
}