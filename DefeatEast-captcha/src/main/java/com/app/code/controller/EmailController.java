//package com.app.code.controller;
//
//import java.util.Date;
//import org.apache.commons.mail.EmailException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import com.app.exception.CacheException;
//import com.app.exception.EmailErrorException;
//import com.app.exception.FrequencyException;
//import com.app.code.service.CacheService;
//import com.app.code.util.EmailUtil;
//import com.app.controller.base.AppConfig;
//import com.app.controller.base.BaseController;
//import com.app.controller.base.OperateResult;
//import com.app.utils.KeyUtil;
//import com.app.utils.RandomCode;
//
//@RestController
//public class EmailController extends BaseController {
//
//	@Autowired
//	private EmailUtil emailUtil;
//
//	@Autowired
//	private CacheService cacheService;
//
//	@RequestMapping("/email")
//	public OperateResult smsCode(@RequestParam("address") String address)
//			throws EmailErrorException, CacheException, FrequencyException, Exception {
//		try {
//			if (!KeyUtil.isEmail(address)) {
//				throw new EmailException();
//			}
//
//			String result = cacheService.getCacheCode(address);
//			if (result != null) {
//				throw new FrequencyException();
//			}
//
//			String code = RandomCode.getCode();
//			emailUtil.sendEmail(address, code);
//			Boolean cache = cacheService.cacheCode(address, code, new Date(AppConfig.COED_EXPIRY));
//			if (!cache) {
//				throw new CacheException();
//			}
//
//			return result("发送成功");
//		} catch (EmailException e) {
//			e.printStackTrace();
//			throw new EmailErrorException();
//		}
//	}
//}
