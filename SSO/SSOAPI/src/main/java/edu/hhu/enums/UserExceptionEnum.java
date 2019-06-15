package edu.hhu.enums;

public enum UserExceptionEnum {
	//异常枚举
	USERNAME_ERROR(500,"用户名不存在"),
    PASSWORD_ERROR(500,"用户名或密码错误");

    private Integer code;//返回码
    private String msg;//返回信息

    UserExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
    
}
