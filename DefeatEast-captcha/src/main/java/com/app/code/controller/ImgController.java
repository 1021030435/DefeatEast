package com.app.code.controller;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.app.exception.CacheException;
import com.app.base.BaseController;
import com.app.code.service.KeepCodeService;

import static com.app.code.online.ImgOnline.*;
import static com.app.utils.RandomCode.*;

@Controller
public class ImgController extends BaseController {

	private static final String TYPE = "image/jpeg";

	private static final String NAME = "jpg";

	@Autowired
	private KeepCodeService codeService;

	@RequestMapping("/img")
	public void imgCode(@RequestParam("gUid") String gUid, HttpServletResponse response)
			throws CacheException, Exception {
		response.setContentType(TYPE);
		String code = getCode();
		BufferedImage img = createImage(code);
		Boolean success = codeService.put(gUid, code);
		if (!success) {
			throw new CacheException();
		}

		ImageIO.write(img, NAME, response.getOutputStream());
	}
}
