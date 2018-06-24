package com.app.code.util;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {

	@Value("${email.hostName}")
	private String hostName;

	@Value("${email.from}")
	private String from;

	@Value("${email.psw}")
	private String psw;

	public boolean sendEmail(String emailaddress, String code) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.setHostName(hostName);
		email.setCharset("UTF-8");
		email.addTo(emailaddress);
		email.setFrom(from);
		email.setAuthentication(from, psw);
		email.setSubject("欢迎使用XXX购物平台");
		email.setMsg("您的验证码是:" + code);
		email.send();
		return true;
	}
}