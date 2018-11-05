package com.dadagum.team.common.exception.handler;

import com.dadagum.team.common.api.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice("com.dadagum.controller")
public class GlobalControllerExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler({RuntimeException.class})
    @ResponseBody
    public ResponseEntity<JsonResult<?>> handleRuntimeException(RuntimeException ex){
        logger.error(ex.getMessage());
        return new ResponseEntity<>(new JsonResult<>(null, "操作失败"), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
