package edu.hhu.exception;

import edu.hhu.enums.UserExceptionEnum;

public class UserException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	private Integer code;// 返回码

	//无参构造方法,一定要有.否则会报远程调用异常
	public UserException() {}

	// 构造方法
	public UserException(UserExceptionEnum userExceptionEnum) {
		super(userExceptionEnum.getMsg());
		this.code = userExceptionEnum.getCode();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
