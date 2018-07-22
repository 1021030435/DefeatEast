package com.usercenter.sevice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.app.exception.PswException;
import com.app.exception.UserExistException;
import com.app.exception.UserNotFoundException;
import com.usercenter.db.mapper.UserMapper;
import com.usercenter.db.model.User;
import static com.app.utils.RandomCode.*;
import static com.app.utils.MD5Utils.*;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper mapper;

	@Override
	@Cacheable(cacheNames = "user", key = "#p0")
	public User login(String link, String psw) throws UserNotFoundException, PswException, Exception {
		User user = findByLink(link);
		if (user == null) {
			throw new UserNotFoundException();
		}

		psw = str2MD5(str2MD5(psw) + user.getSalt());
		if (!psw.equals(user.getPsw())) {
			throw new PswException();
		}
		return user;
	}

	@Override
	@CachePut(cacheNames = "user", key = "#p0")
	public User signin(String link, Integer linkType, String psw) throws UserExistException, Exception {
		User user = findByLink(link);
		if (user != null) {
			throw new UserExistException();
		}

		String salt = getCode();
		user = new User();
		user.setLink(link);
		user.setLinkType(linkType);
		user.setSalt(salt);
		user.setPsw(str2MD5(str2MD5(psw) + salt));
		mapper.signin(user);
		return user;
	}

	@Cacheable("user")
	private User findByLink(String link) throws Exception {
		return mapper.findByLink(link);
	}
	
	@CachePut(cacheNames = "user", key = "#p0")
	@Override
	public User updatePsw(String link, String psw) throws Exception {
		User user = findByLink(link);
		if (user == null) {
			throw new UserNotFoundException();
		}
		String salt = getCode();
		user.setSalt(salt);
		user.setPsw(str2MD5(str2MD5(psw)+salt));
		mapper.updateById(user);
		
		return user;
	}

}
