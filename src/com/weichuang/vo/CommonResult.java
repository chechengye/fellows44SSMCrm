package com.weichuang.vo;

public class CommonResult<T> {

    private int code;
    private String message;
    private T data;
    public CommonResult() {
    }
    public CommonResult(String message) {
        this.code = 200;
        this.message = message;
    }

    public CommonResult(String message, T data) {
        this.code = 200;
        this.message = message;
        this.data = data;
    }

    public CommonResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
