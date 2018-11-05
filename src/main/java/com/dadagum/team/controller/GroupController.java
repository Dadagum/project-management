package com.dadagum.team.controller;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.constant.JsonCode;
import com.dadagum.team.common.exception.def.NotAnImageException;
import com.dadagum.team.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping("/")
    public JsonResult<?> add(Group group){
        groupService.add(group);
        return new JsonResult<>(group, "增加团队成功", JsonCode.SUCCESS);
    }

    @DeleteMapping("/")
    public JsonResult<?> delete(int id){
        groupService.delete(id);
        return new JsonResult<>(null, "删除团队成功", JsonCode.SUCCESS);
    }

    @GetMapping("/{id}")
    public JsonResult<?> get(@PathVariable int id){
        Group result = groupService.get(id);
        return new JsonResult<>(result, "得到团队信息成功", JsonCode.SUCCESS);
    }

    @PutMapping("/")
    public JsonResult<?> update(Group group){
        groupService.update(group);
        return new JsonResult<>(group, "更新团队信息成功", JsonCode.SUCCESS);
    }

    @ExceptionHandler
    public JsonResult<?> handleRuntimeException(RuntimeException ex){
        return new JsonResult<>(null, "系统错误 : " + ex.getMessage(), 1);
    }

    @GetMapping("/ex")
    public String testThrowException(){
        throw new NotAnImageException();
    }
}
