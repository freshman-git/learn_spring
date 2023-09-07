package com.example.demo.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseResult {

    private Integer code;

    private String message;

    private Object data;

    public static ResponseResult match(){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),"MATCH",null);
    }
    public static ResponseResult match(Object data){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),"MATCH",data);
    }
    public static ResponseResult match(Object data,String message){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),message,data);
    }
    public static ResponseResult match(String message){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),message,null);
    }
    public static ResponseResult noap(){
        return new ResponseResult(ResultEnumCode.NOAP.getCode(),"NOAP",null);
    }
    public static ResponseResult noap(Object data){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),"NOAP",data);
    }
    public static ResponseResult noap(Object data,String message){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),message,data);
    }
    public static ResponseResult noap(String message){
        return new ResponseResult(ResultEnumCode.MATCH.getCode(),message,null);
    }
}
