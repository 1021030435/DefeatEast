package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.app.base.AdviceEnum.*;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.CacheException;
import com.app.exception.FrequencyException;
import com.app.exception.EmailErrorException;
import com.app.exception.CacheSMSCodeException;
import com.app.exception.PhoneException;

@RestControllerAdvice
public class CodeAdvice extends BaseController{

	@ExceptionHandler(value = CacheException.class)
	public OperateResult<Object> test(CacheException ex) {
		ex.printStackTrace();
		return result(CACHE_ERROR);
	}
	
	@ExceptionHandler(value = FrequencyException.class)
	public OperateResult<Object> test(FrequencyException ex) {
		ex.printStackTrace();
		return result(FREQUENCY_ERROR);
	}
	
	@ExceptionHandler(value = EmailErrorException.class)
	public OperateResult<Object> test(EmailErrorException ex) {
		ex.printStackTrace();
		return result(EMAIL_ERROR);
	}
	
	@ExceptionHandler(value = CacheSMSCodeException.class)
	public OperateResult<Object> test(CacheSMSCodeException ex) {
		ex.printStackTrace();
		return result(CACHE_ERROR);
	}
	
	@ExceptionHandler(value = PhoneException.class)
	public OperateResult<Object> test(PhoneException ex) {
		ex.printStackTrace();
		return result(PHONE_ERROR);
	}
}
