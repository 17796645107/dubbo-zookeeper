package edu.hhu.service;

import edu.hhu.domain.User;
import edu.hhu.exception.UserException;

public interface UserService {

	public User isLogin(String username, String password)throws UserException;
}
