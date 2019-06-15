package edu.hhu.enums;

public enum RedisExceptionEnum {
	//异常枚举
    TIME_ERROR(500,"用户超时");

    private Integer code;//返回码
    private String msg;//返回信息

    RedisExceptionEnum(Integer code, String msg) {
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
