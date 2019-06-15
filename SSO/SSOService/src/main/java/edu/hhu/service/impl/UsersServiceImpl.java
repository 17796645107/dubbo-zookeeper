package edu.hhu.service.impl;

import edu.hhu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.hhu.enums.UserExceptionEnum;
import edu.hhu.exception.UserException;
import edu.hhu.mapper.UsersMapper;
import edu.hhu.service.UserService;
import edu.hhu.util.MD5Util;

@Service("UsersServiceImpl")
public class UsersServiceImpl implements UserService{
	@Autowired
	@Qualifier("UsersMapper")
	private UsersMapper userMapper;

	@Transactional(propagation = Propagation.REQUIRED,readOnly = true)
	public User isLogin(String username, String password) throws UserException{
		User user = userMapper.selectUserByUsername(username);
		if (user == null) {
			throw new UserException(UserExceptionEnum.USERNAME_ERROR);
		}
		if (!MD5Util.getMD5(password).equals(user.getUserPass())) {
			throw new UserException(UserExceptionEnum.PASSWORD_ERROR);
		}
		return user;
	}

}
