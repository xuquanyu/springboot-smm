package com.example.demo.constant;

import java.io.Serializable;
import java.util.Map;

public class Result<T> implements Serializable {

    /**
     * 返回状态码
     */
    public Integer code;

    /**
     * 返回描述信息
     */
    private String msg;

    /**
     * 返回内容体
     */
    private T data;
    /**
     * 其他内容
     */
    private Map<String, Object> dataMap;

    public Result() {
        this.code = 200;
        this.msg = "SUCCESS";
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code, String msg, T data, Map<String, Object> dataMap) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.dataMap = dataMap;
    }

    public Result<T> setCode(ResultCode resultCode) {
        this.code = resultCode.getCode();
        return this;
    }

    public int getCode() {
        return code;
    }

    public Result<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> setData(T data) {
        this.data = data;
        return this;
    }

}
