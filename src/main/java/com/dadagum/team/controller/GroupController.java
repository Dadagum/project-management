package com.dadagum.team.controller;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Role;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.service.GroupService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    public ResponseEntity<JsonResult<?>> add(Group group){
        // groupService.add(group);
        group.setId(10000);
        return new ResponseEntity<>(new JsonResult<>(group, "增加团队成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<JsonResult<?>> delete(@PathVariable int id){
        // groupService.delete(id);
        return new ResponseEntity<>(new JsonResult<>(null, "删除团队成功"), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JsonResult<?>> get(@PathVariable int id){
        //Group result = groupService.get(id);
        Group result = new Group(10000, "朱世靖小分队", 10000, new Date());
        return new ResponseEntity<>(new JsonResult<>(result, "得到团队信息成功"), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<JsonResult<?>> update(Group group, @PathVariable int id){
        // groupService.update(group);
        group.setId(10000);
        return new ResponseEntity<>(new JsonResult<>(group, "更新团队信息成功"), HttpStatus.OK);
    }

    @PostMapping("/{id}/users")
    @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> addTeamMate(@PathVariable int id, User user) {
        return new ResponseEntity<>(new JsonResult<>(user, "添加成员成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{gid}/users/{uid}")
    public ResponseEntity<JsonResult<?>> deleteTeamMate(@PathVariable int gid, @PathVariable int uid){
        return new ResponseEntity<>(new JsonResult<>(null, "踢出成员成功"), HttpStatus.OK);
    }

    @GetMapping("/{id}/users")
    public ResponseEntity<JsonResult<?>> getTeamMates(@PathVariable int id) {
        List<User> list = new ArrayList<>();
        list.add(new User("朱世靖", Role.USER.value()));
        list.add(new User("朱世靖爸爸", Role.USER.value()));
        return new ResponseEntity<>(new JsonResult<>(list, "成功获得队友列表"), HttpStatus.OK);
    }
}
