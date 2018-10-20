package com.dadagum.team.common.exception.handler;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.constant.JsonCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.dadagum.controller")
public class GlobalControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public JsonResult<?> handleRuntimeException(RuntimeException ex){
        logger.error(ex.getMessage());
        return new JsonResult<>(null, "操作失败", JsonCode.FAIL);
    }
}
