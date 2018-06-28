package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.app.base.AdviceEnum.*;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.KeyException;
import com.app.exception.ParamException;

@RestControllerAdvice
public class ShowAdvice extends BaseController {

	@ExceptionHandler(value = KeyException.class)
	public OperateResult<Object> test(KeyException ex) {
		ex.printStackTrace();
		return result(KEY_ERROR);
	}

	@ExceptionHandler(value = ParamException.class)
	public OperateResult<Object> test(ParamException ex) {
		ex.printStackTrace();
		return result(PARAM_ERROR);
	}
}
