package com.example.demo.constant;

public class Response {

    public static <T> Result<T> makeOKRsp() {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMsg("success");
    }

    public static <T> Result<T> makeOKRsp(String message) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMsg(message);
    }

    public static <T> Result<T> makeOKRsp(T data) {
        return new Result<T>().setCode(ResultCode.SUCCESS).setMsg("success").setData(data);
    }

    public static <T> Result<T> makeErrRsp(String message) {
        return new Result<T>().setCode(ResultCode.SERVICE_EXCEPTIONS).setMsg(message);
    }

    public static <T> Result<T> makeRsp(int code, String msg) {
        return new Result<T>().setCode(code).setMsg(msg);
    }

    public static <T> Result<T> makeRsp(int code, String msg, T data) {
        return new Result<T>().setCode(code).setMsg(msg).setData(data);
    }
}
