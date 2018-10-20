package com.dadagum.team.common.exception.def;

public class NotAnImageException extends RuntimeException{

    public NotAnImageException() {
        super("上传文件不是一张图片");
    }
}
