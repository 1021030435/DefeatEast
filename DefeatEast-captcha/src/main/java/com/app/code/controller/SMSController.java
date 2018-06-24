//package com.app.code.controller;
//
//import java.util.Date;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import com.app.exception.CacheSMSCodeException;
//import com.app.exception.FrequencyException;
//import com.app.exception.PhoneException;
//import com.app.code.service.CacheService;
//import com.app.controller.base.AppConfig;
//import com.app.controller.base.BaseController;
//import com.app.controller.base.OperateResult;
//import com.app.utils.KeyUtil;
//import com.app.utils.RandomCode;
//
//@RestController
//public class SMSController extends BaseController {
//
//	@Autowired
//	private CacheService cacheService;
//
//	@RequestMapping("/sms")
//	public OperateResult smsCode(@RequestParam("phone") String phone)
//			throws PhoneException, FrequencyException, CacheSMSCodeException, Exception {
//		if (!KeyUtil.isPhone(phone)) {
//			throw new PhoneException();
//		}
//
//		String result = cacheService.getCacheCode(phone);
//		if (result != null) {
//			throw new FrequencyException();
//		}
//
//		String code = RandomCode.getCode();
//		cacheService.cacheSMSCode(phone, code, new Date(AppConfig.COED_EXPIRY));
//		return result("发送成功");
//	}
//}
