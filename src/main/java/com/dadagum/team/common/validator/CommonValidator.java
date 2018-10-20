package com.dadagum.team.common.validator;

public class CommonValidator {

    private CommonValidator(){
    }

    /**
     * 检查字符长度是否在规定长度范围
     * @param str 被检查的字符串
     * @param length 规定的长度范围 [0, length]
     */
     public static boolean checkStringLength(String str, int length){
        if (length < 0)
            throw new IllegalArgumentException();
        return str == null || str.length() <= length;
    }


}
