package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.model.Project;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.ProjectQuery;
import com.dadagum.team.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/projects")
@Api(tags = {"团队项目功能相关接口"})
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    @ApiOperation(value = "增加团队项目", notes = "必填字段: name, description, startTime, endTime, gid, uid")
    public ResponseEntity<JsonResult<?>> addProject(Project project, @RequestAttribute JwtUserDTO userInfo) {
        projectService.insertProject(userInfo, project);
        project.setId(10000);
        return ResponseEntity.ok().body(new JsonResult<>(project, "创建团队项目成功"));
    }

    @DeleteMapping("/{pid}")
    @ApiOperation(value = "删除团队项目", notes = "url参数: pid")
    public ResponseEntity<JsonResult<?>> deleteProject(@PathVariable int pid, @RequestAttribute JwtUserDTO userInfo) {
        projectService.deleteProject(userInfo, pid);
        return ResponseEntity.ok().body(new JsonResult<>(null, "删除团队项目成功"));
    }

    @GetMapping("/{pid}")
    @ApiOperation(value = "得到用户某一个项目的详细信息", notes = "url参数: pid")
    public ResponseEntity<JsonResult<?>> getUserProject(@PathVariable int pid, @RequestAttribute JwtUserDTO userInfo) {
        Project project = projectService.getProject(userInfo, pid);
        return ResponseEntity.ok().body(new JsonResult<>(project, "成功得到项目列表"));
    }

    @GetMapping
    @ApiOperation(value = "得到用户项目列表", notes = "请求参数待定")
    public ResponseEntity<JsonResult<?>> listUserProject(@RequestAttribute JwtUserDTO userInfo, ProjectQuery query) {
        List<Project> result = projectService.listUserProject(userInfo, query);
        return ResponseEntity.ok().body(new JsonResult<>(result, "成功得到项目列表"));
    }

    @PutMapping("/{pid}")
    @ApiOperation(value = "更新某一个项目的信息", notes = "必填参数：gid, uid. 选填参数:name, description, startTime, endTime. url参数: pid")
    public ResponseEntity<JsonResult<?>> updateProject(@PathVariable int pid, Project project ,@RequestAttribute JwtUserDTO userInfo) {
        project.setId(pid);
        projectService.updateProject(userInfo, project);
        return ResponseEntity.ok().body(new JsonResult<>(project, "更新成功"));
    }

    @PostMapping("/{pid}/users")
    @ApiOperation(value = "分派项目给特定组员(一个或者多个)", notes = "请求参数待定")
    public ResponseEntity<JsonResult<?>> addUser2Project(@PathVariable int pid, @RequestBody Map<String, List<Integer>> map, @RequestAttribute JwtUserDTO userInfo) {
        List<Integer> users = map.get("users");
        projectService.assignUserProject(userInfo, users, pid);
        return ResponseEntity.ok().body(new JsonResult<>(null, "添加成员成功"));
    }

    @DeleteMapping("/{pid}/users")
    @ApiOperation(value = "踢出项目中的特定组员(一个或者多个)", notes = "请求参数待定")
    public ResponseEntity<JsonResult<?>> deleteUserFromProject(@PathVariable int pid, @RequestBody Map<String, List<Integer>> map, @RequestAttribute JwtUserDTO userInfo) {
        List<Integer> users = map.get("users");
        projectService.deleteUserFromProject(userInfo, users, pid);
        return ResponseEntity.ok().body(new JsonResult<>(null, "删除成员成功"));
    }


}
