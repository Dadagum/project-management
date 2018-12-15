package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.exception.def.UserRegistrationException;
import com.dadagum.team.common.model.User;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.validator.UserValidator;
import com.dadagum.team.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"通用接口"})
public class CommonController {

    private final UserService userService;

    @Autowired
    public CommonController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/registration")
    @ApiOperation(value = "账号注册", notes = "必填字段：userName, password")
    public ResponseEntity<JsonResult<?>> register(User user){
        System.out.println("进来了");
        userService.insertUser(user);
        JsonResult<?> result = new JsonResult<>(user, "注册成功");
        return ResponseEntity.ok().body(result);
    }

    @PostMapping("/authentication")
    @ApiOperation(value = "用户登陆", notes = "必填字段：userName, password必填。 注意：登陆成功会在Set-Cookie字段中返回token，包括基本用户的认证信息，此后每一次请求请在http header中加入Authorization字段，value为得到的token，如果token过期需要重新登陆认证")
    public ResponseEntity<JsonResult<?>> login(User user){
        String jwt = userService.login(user);
        JsonResult<?> result = new JsonResult<>(user, "登陆成功");
        System.out.println("return user : " + user);
        return ResponseEntity.ok().header("Authorization", jwt).body(result);
    }

    @GetMapping("/users/{uid}")
    @ApiOperation(value = "得到某一个用户概要信息", notes = "url参数：团队id， 用户id")
   // @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> getTeamMateById(@PathVariable int uid, @RequestAttribute JwtUserDTO userInfo) {
        return ResponseEntity.ok().body(new JsonResult<>(userService.getUser(uid), "成功获得队友列表"));
    }

}
