package com.dadagum.team.controller;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Role;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.service.GroupService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/groups")
@Api(tags = {"团队模块功能相关接口"})
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @PostMapping
    @ApiOperation(value = "新建一个团队", notes = "必填字段：name")
    public ResponseEntity<JsonResult<?>> addGroup(Group group){
        groupService.insertGroup(group);
        group.setId(10000); // 暂时模拟团队id
        return ResponseEntity.ok().body(new JsonResult<>(group, "增加团队成功"));
    }

    @DeleteMapping("/{gid}")
    @ApiOperation(value = "删除一个团队", notes = "url参数：团队id")
    public ResponseEntity<JsonResult<?>> deleteGroup(@PathVariable int gid, @RequestAttribute JwtUserDTO userInfo){
        groupService.deleteGroup(gid, userInfo);
        return ResponseEntity.ok().body(new JsonResult<>(null, "删除团队成功"));
    }

    @GetMapping("/{gid}")
    @ApiOperation(value = "返回一个团队的详细信息", notes = "url参数：团队id")
    public ResponseEntity<JsonResult<?>> getGroup(@PathVariable int gid, @RequestAttribute JwtUserDTO userInfo){
        Group result = groupService.getGroup(gid, userInfo);
        return ResponseEntity.ok().body(new JsonResult<>(result, "得到团队信息成功"));
    }

    @GetMapping
    @ApiOperation(value = "返回某一个用户的团队列表", notes = "筛选条件待议")
    public ResponseEntity<JsonResult<?>> listGroups(@RequestAttribute JwtUserDTO userInfo){
        List<Group> result = groupService.listGroup(userInfo);
        return ResponseEntity.ok().body(new JsonResult<>(result, "得到团队信息列表成功"));
    }

    @PutMapping("/{gid}")
    @ApiOperation(value = "更新一个团队的基本信息", notes = "url参数：团队id")
    public ResponseEntity<JsonResult<?>> updateGroup(Group group, @PathVariable int gid, @RequestAttribute JwtUserDTO userInfo){
        group.setId(gid);
        groupService.updateGroup(group, userInfo);
        group.setId(10000);
        return ResponseEntity.ok().body(new JsonResult<>(group, "更新团队信息成功"));
    }

    @PostMapping("/{gid}/users")
    @ApiOperation(value = "邀请用户加入团队", notes = "必填字段：用户id. url参数：团队id")
    @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> addTeamMate(@ApiParam("团队id")@PathVariable int gid, @ApiParam("用户id")@RequestParam int uid, @RequestAttribute JwtUserDTO userInfo) {
        groupService.insertUser2Group(userInfo, gid, uid);
        return ResponseEntity.ok().body(new JsonResult<>(null, "邀请成员成功"));
    }

    @DeleteMapping("/{gid}/users/{uid}")
    @ApiOperation(value = "把用户踢出团队", notes = "url参数：团队id， 用户id")
    public ResponseEntity<JsonResult<?>> deleteTeamMate(@ApiParam("团队id")@PathVariable int gid, @ApiParam("用户id")@PathVariable int uid, @RequestAttribute JwtUserDTO userInfo){
        groupService.deleteUserFromGroup(userInfo, gid, uid);
        return ResponseEntity.ok().body(new JsonResult<>(null, "踢出成员成功"));
    }

    @GetMapping("/{gid}/users")
    @ApiOperation(value = "得到团队中的队友列表", notes = "url参数：团队id")
    @JsonView(User.PublicUserInfo.class)
    public ResponseEntity<JsonResult<?>> listTeamMate(@PathVariable int gid) {
        List<User> list = new ArrayList<>();
        list.add(new User("朱世靖", Role.USER.value()));
        list.add(new User("朱世靖爸爸", Role.USER.value()));
        return new ResponseEntity<>(new JsonResult<>(list, "成功获得队友列表"), HttpStatus.OK);
    }
}
