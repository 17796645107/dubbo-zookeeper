package edu.hhu.handle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.hhu.exception.UserException;
import edu.hhu.util.ResultUtil;
import edu.hhu.vo.Result;

/**
 * @Author: 邓宁
 * @Date: Created in 22:59 2018/10/26
 */

@ControllerAdvice
// 异常捕获类
public class ExceptionHandle {

	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public Result<Object> handle(Exception e) {
		System.out.println(e.getClass().getName());
		// 判断是否为自定义异常
		if (e instanceof UserException) {
			UserException userException = (UserException) e;
			return ResultUtil.error(userException.getCode(),
					userException.getMessage());
		} else {
			// 否则就返回-1.未知错误
			System.out.println("【系统异常】={" + e + "}");
			return ResultUtil.error(-1, "未知错误");
		}

	}
}
