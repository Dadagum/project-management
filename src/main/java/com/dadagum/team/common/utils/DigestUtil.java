package com.dadagum.team.common.utils;

import org.springframework.util.DigestUtils;

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Random;

public class DigestUtil {

    private static final Random random = new SecureRandom();
    private static final int LEN = 16;

    public static String createSalt(){
        byte[] salt = new byte[LEN];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String md5Hash(String src, String salt){
        String str = src + salt;
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
