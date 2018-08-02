package com.gateway.service;

import java.util.Date;

public interface UserService {

	void insertUser(Integer userId, String token, Date date);

}
