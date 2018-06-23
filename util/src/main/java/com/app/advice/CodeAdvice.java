package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.app.controller.base.AppConfig;
import com.app.controller.base.BaseController;
import com.app.controller.base.OperateResult;
import com.app.exception.CacheException;
import com.app.exception.FrequencyException;
import com.app.exception.EmailErrorException;
import com.app.exception.CacheSMSCodeException;
import com.app.exception.PhoneException;

@RestControllerAdvice
public class CodeAdvice extends BaseController{

	@ExceptionHandler(value = CacheException.class)
	public OperateResult test(CacheException ex) {
		ex.printStackTrace();
		return result(AppConfig.CACHE_ERROR, "cache错误");
	}
	
	@ExceptionHandler(value = FrequencyException.class)
	public OperateResult test(FrequencyException ex) {
		ex.printStackTrace();
		return result(AppConfig.CODE_EXIST_ERROR, "验证码发送频繁");
	}
	
	@ExceptionHandler(value = EmailErrorException.class)
	public OperateResult test(EmailErrorException ex) {
		ex.printStackTrace();
		return result(AppConfig.EMAIL_ERROR, "邮箱错误");
	}
	
	@ExceptionHandler(value = CacheSMSCodeException.class)
	public OperateResult test(CacheSMSCodeException ex) {
		ex.printStackTrace();
		return result(AppConfig.CACHE_ERROR, "cache错误");
	}
	
	@ExceptionHandler(value = PhoneException.class)
	public OperateResult test(PhoneException ex) {
		ex.printStackTrace();
		return result(AppConfig.PHONE_ERROR, "手机号错误");
	}
}
