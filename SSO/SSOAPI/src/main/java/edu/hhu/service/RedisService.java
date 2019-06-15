package edu.hhu.service;

import edu.hhu.domain.User;

public interface RedisService {

	public String  setUser(User user);

	public User getUser(String token)throws RuntimeException;

}
