package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.common.validator.UserValidator;
import com.dadagum.team.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import java.util.Date;

@RestController
@Api(tags = {"注册登陆相关接口"})
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    @ApiOperation(value = "账号注册", notes = "必填字段：userName, password")
    public ResponseEntity<JsonResult<?>> register(User user){
        if (UserValidator.checkForRegistration(user)){
            // userService.addUser(user);
            JsonResult<?> result = new JsonResult<>(user, "注册成功");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        JsonResult<?> result = new JsonResult<>(null, "注册失败");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/authentication")
    @ApiOperation(value = "用户登陆", notes = "必填字段：userName, password必填。 注意：登陆成功会在Set-Cookie字段中返回token，包括基本用户的认证信息，此后每一次请求请在http header中加入Authorization字段，value为得到的token，如果token过期需要重新登陆认证")
    public ResponseEntity<JsonResult<?>> login(User user, ServletResponse servletResponse){
        if (UserValidator.checkForLogin(user)){
//            String jwt = userService.login(user);
//            HttpServletResponse response = (HttpServletResponse) servletResponse;
//            response.addHeader("Authorization", jwt);
            user.setId(10000);
            JsonResult<?> result = new JsonResult<>(user, "登陆成功");
            return new ResponseEntity<>(result, HttpStatus.OK);
        }
        JsonResult<?> result = new JsonResult<>(null, "登陆失败");
        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
