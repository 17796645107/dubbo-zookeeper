package edu.hhu.exception;

import edu.hhu.enums.RedisExceptionEnum;

public class RedisException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	private Integer code;//返回码

    //无参构造方法,一定要有.否则会报远程调用异常
    public RedisException(){}

    //构造方法
    public RedisException(RedisExceptionEnum redisExceptionEnum){
        super(redisExceptionEnum.getMsg());
        this.code=redisExceptionEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
