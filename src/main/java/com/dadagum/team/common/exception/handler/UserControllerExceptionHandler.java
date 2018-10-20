package com.dadagum.team.common.exception.handler;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.constant.JsonCode;
import com.dadagum.team.common.exception.def.UserAuthenticationException;
import com.dadagum.team.controller.UserController;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice(assignableTypes = {UserController.class})
public class UserControllerExceptionHandler {

    @ExceptionHandler({UserAuthenticationException.class})
    @ResponseBody
    public JsonResult<?> handleUserHasAlreadyExistException(UserAuthenticationException ex){
        return new JsonResult<>(null, ex.getMessage(), JsonCode.FAIL);
    }


}
