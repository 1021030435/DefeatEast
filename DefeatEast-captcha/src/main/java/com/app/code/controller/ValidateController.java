//package com.app.code.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import com.app.code.service.CacheService;
//import com.app.controller.base.AppConfig;
//import com.app.controller.base.BaseController;
//import com.app.controller.base.OperateResult;
//import com.app.model.ValidateModel;
//
//@RestController
//public class ValidateController extends BaseController {
//
//	@Autowired
//	private CacheService cacheService;
//
//	@RequestMapping("/validate")
//	public OperateResult through(@RequestBody ValidateModel model) throws Exception {
//		String value = cacheService.getCacheCode(model.getKey());
//		if (value == null) {
//			return result(AppConfig.VALIDATE_ERROR, "验证错误");
//		}
//
//		if (!model.getCode().toLowerCase().equals(value.toLowerCase())) {
//			return result(AppConfig.VALIDATE_ERROR, "验证错误");
//		}
//		return result(AppConfig.SUCCESS, AppConfig.SUCCESS_MSG);
//	}
//}
