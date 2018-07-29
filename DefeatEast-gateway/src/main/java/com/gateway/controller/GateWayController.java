package com.gateway.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.base.AppConfig;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.KeyException;
import com.app.exception.ParamException;
import com.app.exception.PswException;
import com.app.exception.UserNotFoundException;
import com.app.model.UserModel;
import com.app.model.ValidateModel;
import com.app.utils.HttpUtil;
import com.app.utils.JavaWebToken;
import com.app.utils.KeyUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gateway.db.model.User;
import com.gateway.service.UserService;
import static com.app.base.AdviceEnum.*;

import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletResponse;

@RestController
public class GateWayController extends BaseController {
	
	
	@Autowired
	private RedisTemplate<String, String> template;

	@Autowired
	private UserService userService;

	@Value("${usercenter}")
	private String usercenter;
	
	@Value("${code_server}")
	private String code_server;

	@RequestMapping("/signin")
	public OperateResult signin(@RequestParam("key") String key, @RequestParam("psw") String psw,
			@RequestParam("name") String name, @RequestParam("code") String code)
			throws KeyException, ParamException, Exception {
		if (!KeyUtil.isPhone(key) &&!KeyUtil.isEmail(key)) {
			throw new KeyException();
		}

		if (psw.trim().equals("") || name.trim().equals("") || code.trim().equals("")) {
			throw new ParamException();
		}

		ObjectMapper mapper = new ObjectMapper();
		ValidateModel validate = new ValidateModel();
		validate.setCode(code);//验证码
		validate.setKey(key);//账户
		String json = mapper.writeValueAsString(validate);
		String result = HttpUtil.postJson(code_server + "validate", json);
		OperateResult operate = mapper.readValue(result, OperateResult.class);
		if (!operate.getErrno().equals(SUCCESS.getErrno())) {
			return operate;
		}

		UserModel model = new UserModel();
		if(KeyUtil.isPhone(key)) {
			model.setLinkType(0);
		}else {
			model.setLinkType(1);
		}
		model.setKey(key);
		model.setName(name);
		model.setPsw(psw);
		json = mapper.writeValueAsString(model);
		result = HttpUtil.postJson(usercenter + "/user/signin", json);
		operate = mapper.readValue(result, OperateResult.class);
		if (!operate.getErrno().equals(SUCCESS.getErrno())) {
			return operate;
		}

		return result();
	}

	@RequestMapping("/login")
	public OperateResult login(@RequestParam("psw") String psw, @RequestParam("key") String key,
			HttpServletResponse response) throws KeyException, ParamException, Exception {
		if (psw.trim().equals("") || key.trim().equals("")) {
			throw new ParamException();
		}

		ObjectMapper mapper = new ObjectMapper();
		UserModel user = new UserModel();
		user.setKey(key);
		user.setPsw(psw);
		String json = mapper.writeValueAsString(user);
		String result = HttpUtil.postJson(usercenter+"/user/login", json);
		OperateResult operate = mapper.readValue(result, OperateResult.class);
		if (!operate.getErrno().equals(SUCCESS.getErrno())) {
		 return	operate;
		}

		User userr = (User) operate.getData();
		HashMap<String, Object> infoMap = new HashMap<String, Object>();
		infoMap.put(AppConfig.JWT_MAP_KEY, userr.getId());
		String token = JavaWebToken.getToken(infoMap);
		response.setHeader(AppConfig.JWT_RESPONSE, token);
		template.opsForValue().set(userr.getId() + "", token);
		template.expire(userr.getId()
				+ "", AppConfig.JWT_EXPIRE_TIME, TimeUnit.MILLISECONDS);
	//	userService.insertUser(userId, token, new Date(System.currentTimeMillis() + AppConfig.JWT_EXPIRE_TIME));
		return result();
	}
	
	
	

}
