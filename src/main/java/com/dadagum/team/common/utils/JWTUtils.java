package com.dadagum.team.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * JWT，json结构的token，由三个部分组成(header.payload.signature)
 * 1.header：header 用于描述元信息
 * 2.playload：用于携带你希望向服务端传递的信息，例如iss(Issuer), sub(Subject), exp(Expiration time)，或者自己定义的一些字段，playload的字段也可以叫做claims
 * 3.signature：将header和playload分别进行BASE64编码后用'.'拼接称为字符串，然后使用secret作为参数进行hash
 * 即：
 * data = base64urlEncode( header ) + “.” + base64urlEncode( payload )
 * signature = Hash( data, secret );
 */
public class JWTUtils {

    private static final String SECRET = "@#$$%&sdfrtetr$%!#SDFGDJFsdfAWR#$$@#$&^&$@!DCBVEHY";

    public static <T> String createToken(T obj, long age){
        String token = null;
        try {
            String jsonStr = JacksonUtils.writeValueAsString(obj);
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            token = JWT.create()
                    .withClaim("data", jsonStr)
                    .withIssuer("dadagum")
                    .withExpiresAt(new Date(System.currentTimeMillis() + age))
                    .sign(algorithm);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return token;
    }

    public static <T> T decodeAndGet(String token, Class<T> clazz){
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("dadagum")
                    .build();
            DecodedJWT jwt = verifier.verify(token);
            Claim claim = jwt.getClaim("data");
            String jsonStr = claim.asString();
            return JacksonUtils.readValue(jsonStr, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
