package com.app.code.controller;

import static com.app.utils.RandomCode.getNumCode;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.app.exception.EmailErrorException;
import com.app.exception.FrequencyException;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.code.service.KeepCodeService;
import com.app.code.task.CodeQueue;
import com.app.utils.KeyUtil;
import static com.app.base.AdviceEnum.*;
import static com.app.code.online.OnlineEnum.*;

@RestController
public class EmailController extends BaseController {

	@Autowired
	private CodeQueue queue;
	
	@Autowired
	private KeepCodeService codeService;

	@RequestMapping("/email")
	public OperateResult<Object> smsCode(@RequestParam("address") String address)
			throws EmailErrorException, FrequencyException, Exception {
		if (!KeyUtil.isEmail(address)) {
			throw new EmailException();
		}
		
		if (codeService.getCode(address) != null) {
			throw new FrequencyException();
		}

		String code = getNumCode();
		queue.putTask(address, code, EMAIL);
		return result(SUCCESS);
	}
	
}
