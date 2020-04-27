package com.example.demo.exception;

import lombok.Data;

@Data
public class MyException extends RuntimeException {
    //异常状态码
    private String code;
    //异常信息
    private String message;
    //发生的方法，位置等
    private String method;
    //描述
    private String descinfo;

    public MyException(String code, String message, String method, String descinfo) {
        this.code = code;
        this.message = message;
        this.method = method;
        this.descinfo = descinfo;
    }

}
