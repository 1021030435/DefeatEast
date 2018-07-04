package com.app.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.code.service.KeepCodeService;
import com.app.code.task.CodeQueue;
import com.app.exception.FrequencyException;
import com.app.exception.PhoneException;
import static com.app.utils.KeyUtil.*;
import static com.app.utils.RandomCode.*;
import static com.app.base.AdviceEnum.*;
import static com.app.code.online.OnlineEnum.*;

@RestController
public class SMSController extends BaseController {

	@Autowired
	private CodeQueue queue;
	
	@Autowired
	private KeepCodeService codeService;

	@RequestMapping("/sms")
	public OperateResult<Object> smsCode(@RequestParam("phone") String phone)
			throws PhoneException, FrequencyException, Exception {
		if (!isPhone(phone)) {
			throw new PhoneException();
		}
		
		if (codeService.getCode(phone) != null) {
			throw new FrequencyException();
		}

		String code = getNumCode();
		queue.putTask(phone, code, SMS);
		return result(SUCCESS);
	}
	
}
