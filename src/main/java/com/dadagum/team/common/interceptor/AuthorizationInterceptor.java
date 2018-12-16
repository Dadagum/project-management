package com.dadagum.team.common.interceptor;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.utils.JWTUtils;
import com.dadagum.team.common.utils.JacksonUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if (request.getMethod().equals("OPTIONS")){
            return true;
        }

        response.setContentType("application/json; charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String token = request.getHeader("authorization");
        System.out.println("token : " + token);
        if (token == null) {
            returnErrorMessage("请先登录", HttpStatus.FORBIDDEN.value(), response);
            return false;
        }
        JwtUserDTO userInfo;
        try {
            userInfo = JWTUtils.decodeAndGet(token, JwtUserDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("+++");
            returnErrorMessage("请先登录", HttpStatus.FORBIDDEN.value(), response);
            return false;
        }
        request.setAttribute("userInfo", userInfo);
        return true;
    }

    private void returnErrorMessage(String message, int statusCode, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        JsonResult<String> json = new JsonResult<>(null, message);
        String result = null;

        try {
            result = JacksonUtils.writeValueAsString(json);
        } catch (JsonProcessingException e) {
            result = JacksonUtils.<JsonResult>writeValueAsString(new JsonResult(null, "请先登录"));
            response.setStatus(statusCode);
            response.getWriter().write(result);
            e.printStackTrace();
        }
        response.setStatus(statusCode);
        response.getWriter().write(result);

    }
}
