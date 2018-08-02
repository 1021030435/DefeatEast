package com.app.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.code.service.KeepCodeService;
import com.app.exception.CodeException;
import com.app.model.ValidateModel;
import static com.app.base.AdviceEnum.*;

@RestController
public class ValidateController extends BaseController {

	@Autowired
	private KeepCodeService codeService;

	@RequestMapping("/validate")
	public OperateResult<Object> through(@RequestBody ValidateModel model) throws CodeException, Exception {
		String code = codeService.getCode(model.getKey());
		if (code==null||!code.equals(model.getCode())) {
			throw new CodeException();
		}

		codeService.delete(model.getKey());
		return result(SUCCESS);
	}
}
