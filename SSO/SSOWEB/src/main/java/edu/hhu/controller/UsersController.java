package edu.hhu.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.hhu.vo.Result;
import edu.hhu.domain.User;
import edu.hhu.service.RedisService;
import edu.hhu.service.UserService;
import edu.hhu.util.CookieUtils;
import edu.hhu.util.ResultUtil;

@RequestMapping("/user")
@RestController("UsersController")
public class UsersController {
	@Autowired
	@Qualifier("UserService")
	private UserService userService;

	@Autowired
	@Qualifier("RedisService")
	private RedisService redisService;

	@PostMapping("getUser")
	public Result<Object> isLogin(String username,String password,
			HttpServletRequest request,HttpServletResponse response){
			User user = userService.isLogin(username, password);
			String token = redisService.setUser(user);
			CookieUtils.setCookie(request, response, "token", token);
			return ResultUtil.success(user);
	}

}
