package com.dadagum.team.controller;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Role;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.service.GroupService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/groups")
@Api(tags = {"团队模块功能相关接口"})
public class GroupController {

    @Autowired
    private GroupService groupService;

    @PostMapping
    @ApiOperation(value = "新建一个团队", notes = "必填字段：name")
    public ResponseEntity<JsonResult<?>> addGroup(Group group){
        // groupService.add(group);
        group.setId(10000);
        return new ResponseEntity<>(new JsonResult<>(group, "增加团队成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{gid}")
    @ApiOperation(value = "删除一个团队", notes = "url参数：团队id")
    public ResponseEntity<JsonResult<?>> deleteGroup(@PathVariable int gid){
        // groupService.delete(id);
        return new ResponseEntity<>(new JsonResult<>(null, "删除团队成功"), HttpStatus.OK);
    }

    @GetMapping("/{gid}")
    @ApiOperation(value = "返回一个团队的详细信息", notes = "url参数：团队id")
    public ResponseEntity<JsonResult<?>> getGroup(@PathVariable int gid){
        //Group result = groupService.get(id);
        Group result = new Group(10000, "朱世靖小分队", 10000, new Date());
        return new ResponseEntity<>(new JsonResult<>(result, "得到团队信息成功"), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "返回团队信息列表", notes = "筛选条件待议")
    public ResponseEntity<JsonResult<?>> getGroupList(){
        //Group result = groupService.get(id);
        Group result = new Group(10000, "朱世靖小分队", 10000, new Date());
        return new ResponseEntity<>(new JsonResult<>(result, "得到团队信息列表成功"), HttpStatus.OK);
    }

    @PutMapping("/{gid}")
    @ApiOperation(value = "更新一个团队的基本信息", notes = "url参数：团队id")
    public ResponseEntity<JsonResult<?>> updateGroup(Group group, @PathVariable int gid){
        // groupService.update(group);
        group.setId(10000);
        return new ResponseEntity<>(new JsonResult<>(group, "更新团队信息成功"), HttpStatus.OK);
    }


    @PostMapping("/{gid}/users")
    @ApiOperation(value = "邀请用户加入团队", notes = "必填字段：用户id. url参数：团队id")
    @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> addTeamMate(@PathVariable int gid, @RequestParam int uid) {
        return new ResponseEntity<>(new JsonResult<>(null, "邀请成员成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{gid}/users/{uid}")
    @ApiOperation(value = "把用户踢出团队", notes = "url参数：团队id， 用户id")
    public ResponseEntity<JsonResult<?>> deleteTeamMate(@PathVariable int gid, @PathVariable int uid){
        return new ResponseEntity<>(new JsonResult<>(null, "踢出成员成功"), HttpStatus.OK);
    }

    @GetMapping("/{gid}/users/{uid}")
    @ApiOperation(value = "得到某一个队友信息", notes = "url参数：团队id， 用户id")
    @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> getTeamMate(@PathVariable int gid, @PathVariable int uid) {
        List<User> list = new ArrayList<>();
        list.add(new User("朱世靖", Role.USER.value()));
        list.add(new User("朱世靖爸爸", Role.USER.value()));
        return new ResponseEntity<>(new JsonResult<>(list, "成功获得队友列表"), HttpStatus.OK);
    }

    @GetMapping("/{gid}/users")
    @ApiOperation(value = "得到团队中的信息列表", notes = "url参数：团队id")
    @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> getTeamMateList(@PathVariable int gid) {
        List<User> list = new ArrayList<>();
        list.add(new User("朱世靖", Role.USER.value()));
        list.add(new User("朱世靖爸爸", Role.USER.value()));
        return new ResponseEntity<>(new JsonResult<>(list, "成功获得队友列表"), HttpStatus.OK);
    }
}
