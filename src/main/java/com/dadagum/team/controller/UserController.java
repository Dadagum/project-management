package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.common.validator.UserValidator;
import com.dadagum.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
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
