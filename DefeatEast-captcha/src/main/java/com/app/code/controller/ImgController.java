//package com.app.code.controller;
//
//import java.awt.image.BufferedImage;
//import java.util.Date;
//import javax.imageio.ImageIO;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import com.app.exception.CacheException;
//import com.app.code.service.CacheService;
//import com.app.code.util.ImgUtil;
//import com.app.controller.base.AppConfig;
//import com.app.controller.base.BaseController;
//import com.app.utils.RandomCode;
//
//@Controller
//public class ImgController extends BaseController {
//
//	@Autowired
//	private CacheService cacheService;
//
//	private static final String TYPE = "image/jpeg";
//
//	private static final String NAME = "jpg";
//
//	@RequestMapping("/img")
//	public void imgCode(@RequestParam("gUid") String gUid, HttpServletResponse response)
//			throws CacheException, Exception {
//		response.setContentType(TYPE);
//		String code = RandomCode.getCode();
//		BufferedImage img = ImgUtil.createImage(code);
//		Boolean cache = cacheService.cacheCode(gUid, code, new Date(AppConfig.COED_IMG_EXPIRY));
//		if (!cache) {
//			throw new CacheException();
//		}
//
//		ImageIO.write(img, NAME, response.getOutputStream());
//	}
//}
