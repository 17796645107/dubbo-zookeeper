package edu.hhu.service.impl;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.hhu.domain.User;
import edu.hhu.enums.RedisExceptionEnum;
import edu.hhu.exception.RedisException;
import edu.hhu.service.RedisService;
import edu.hhu.util.JedisClient;
import edu.hhu.util.JsonUtils;

@Service("RedisServiceImpl")
public class RedisServiceImpl implements RedisService{
	@Autowired
	@Qualifier("JedisClientImpl")
	private JedisClient jedisClient;

	public String setUser(User user) {
		user.setUserPass(null);
		String json = JsonUtils.objectToJson(user);
		String token = UUID.randomUUID().toString();
		jedisClient.set(token, json);
		jedisClient.expire(token, 30*60);
		return token;
	}

	public User getUser(String token){
		//重置超时时间
		jedisClient.expire(token, 30*60);
		//获取用户信息
		String json = jedisClient.get(token);
		if (StringUtils.isBlank(json)) {
			throw new RedisException(RedisExceptionEnum.TIME_ERROR);
		}
		return JsonUtils.jsonToPojo(json, User.class);
	}

}
