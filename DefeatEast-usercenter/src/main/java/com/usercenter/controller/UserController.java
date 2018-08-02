package com.usercenter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.base.BaseController;
import com.app.base.OperateResult;
import com.app.exception.PswException;
import com.app.exception.UserExistException;
import com.app.exception.UserNotFoundException;
import com.app.model.UserModel;
import com.usercenter.db.model.User;
import com.usercenter.sevice.UserService;

@RestController
public class UserController extends BaseController {

	@Autowired
	private UserService userService;

	@RequestMapping("/user/login")
	public OperateResult<Integer> login(@RequestBody UserModel model)
			throws UserNotFoundException, PswException, Exception {
		return result(userService.login(model.getKey(), model.getPsw()).getId());
	}
	
	@RequestMapping("/user/updatePsw")
	public OperateResult<Integer> updatePsw(@RequestBody UserModel model)
			throws UserNotFoundException, PswException, Exception {
		return result(userService.updatePsw(model.getKey(),model.getPsw()).getId());
	}

	@RequestMapping("/user/signin")
	public OperateResult<Integer> signin(@RequestBody UserModel model) throws UserExistException, Exception {
		User  User = userService.signin(model.getKey(), model.getLinkType(), model.getPsw());
		
		return result(User.getId());
	}
}
