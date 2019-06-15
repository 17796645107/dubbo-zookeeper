package edu.hhu.util;

import edu.hhu.vo.Result;

/**
 * @Author: 邓宁
 * @Date: Created in 13:58 2018/11/12
 */

public class ResultUtil {
	
    //成功(包含data)
    public static Result<Object> success(Object object){
    	Result<Object> result=new Result<Object>();
        result.setCode(200);
        result.setMsg("成功");
        result.setData(object);
        return result;
    }

    //成功(不包含data)
    public static Result<Object> success(){
        return success(null);
    }

    //失败
    public static Result<Object> error(Integer code,String msg){
    	Result<Object> result=new Result<Object>();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }
}
