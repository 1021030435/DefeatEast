package com.app.advice;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import static com.app.base.AdviceEnum.*;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.PswException;
import com.app.exception.UserExistException;
import com.app.exception.UserNotFoundException;

@RestControllerAdvice
public class UserCenterAdvice extends BaseController{

	@ExceptionHandler(value = PswException.class)
	public OperateResult<Object> test(PswException ex) {
		ex.printStackTrace();
		return result(PSW_ERROR);
	}
	
	@ExceptionHandler(value = UserNotFoundException.class)
	public OperateResult<Object> test(UserNotFoundException ex) {
		ex.printStackTrace();
		return result(USER_ERROR);
	}
	
	@ExceptionHandler(value = UserExistException.class)
	public OperateResult<Object> test(UserExistException ex) {
		ex.printStackTrace();
		return result(USER_EXIST);
	}
}
