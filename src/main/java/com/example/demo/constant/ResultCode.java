package com.example.demo.constant;

import lombok.Getter;

@Getter
public enum ResultCode {
    SUCCESS(200, "Success"),
    SERVICE_EXCEPTIONS(5000, "服务异常,请联系相关人员查看!");

    private Integer code;

    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String getMessage(Integer code) {
        if (code == null) {
            return "";
        }
        for (ResultCode item : ResultCode.values()) {
            if (code.equals(item.getCode())) {

                return item.message;
            }
        }
        return "";
    }

}
