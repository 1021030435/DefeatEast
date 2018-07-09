package com.usercenter.sevice;

import com.app.exception.PswException;
import com.app.exception.UserExistException;
import com.app.exception.UserNotFoundException;
import com.usercenter.db.model.User;

public interface UserService {

	User login(String link, String psw) throws UserNotFoundException, PswException, Exception;

	User signin(String link, Integer linkType, String psw) throws UserExistException, Exception;
}
