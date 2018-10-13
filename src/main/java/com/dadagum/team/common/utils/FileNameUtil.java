package com.dadagum.team.common.utils;

public class FileNameUtil {

    public static String getSuffix(String fileName){
        return fileName.substring(fileName.lastIndexOf("."));
    }

    public static String getUUIDFileName(String fileName){
        return UUIDUtil.getUUID() + getSuffix(fileName);
    }
}
