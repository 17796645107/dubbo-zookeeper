package edu.hhu.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hhu.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import edu.hhu.service.RedisService;

public class UserLoginInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	@Qualifier("RedisService")
	private RedisService redisService;

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Cookie cookies[] = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if ("token".equals(cookie.getName())) {
					String token = cookie.getValue();
					User user = redisService.getUser(token);
					if (user != null) {
						request.getSession().setAttribute("User", user);
						return true;
					}
				}
			}
		}

		response.sendRedirect("http://localhost:8080/SSOWEB/login.html");
		return false;
	}



}
