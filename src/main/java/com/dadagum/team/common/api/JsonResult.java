package com.dadagum.team.common.api;

public class JsonResult<T> {

    private T data;

    private String message;

    public JsonResult(T data, String message) {
        this.data = data;
        this.message = message;
    }

    public JsonResult() {
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
