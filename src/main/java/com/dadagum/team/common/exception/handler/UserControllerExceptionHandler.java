package com.dadagum.team.common.exception.handler;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.exception.def.UserAuthenticationException;
import com.dadagum.team.common.exception.def.UserRegistrationException;
import com.dadagum.team.controller.CommonController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(assignableTypes = {CommonController.class})
public class UserControllerExceptionHandler {

    /**
     * 用户认证失败异常
     */
    @ExceptionHandler({UserAuthenticationException.class})
    @ResponseBody
    public ResponseEntity<JsonResult<?>> handleUserAuthenticationException(UserAuthenticationException ex){
        return new ResponseEntity<>(new JsonResult<>(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }

    /**
     * 用户注册失败异常
     */
    @ExceptionHandler({UserRegistrationException.class})
    @ResponseBody
    public ResponseEntity<JsonResult<?>> handleUserRegistrationException(UserRegistrationException ex){
        return new ResponseEntity<>(new JsonResult<>(null, ex.getMessage()), HttpStatus.BAD_REQUEST);
    }


}
