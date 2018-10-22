package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.common.constant.JsonCode;
import com.dadagum.team.common.validator.UserValidator;
import com.dadagum.team.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public JsonResult<?> register(User user){
        if (UserValidator.checkForRegsigration(user)){
            userService.addUser(user);
        }
        return new JsonResult<>(null, "注册失败", JsonCode.FAIL);
    }

    @PostMapping("/authentication")
    public JsonResult<?> login(User user, ServletResponse servletResponse){
        if (UserValidator.checkForLogin(user)){
            String jwt = userService.login(user);
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.addHeader("Authorization", jwt);
            return new JsonResult<>(null, "登陆成功", JsonCode.SUCCESS);
        }
        return new JsonResult<>(null, "认证失败", JsonCode.FAIL);
    }
}
