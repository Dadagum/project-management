package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Project;
import com.dadagum.team.common.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/projects")
@Api(tags = {"团队项目功能相关接口"})
public class ProjectController {

    @PostMapping
    @ApiOperation(value = "增加团队项目", notes = "必填字段: name, description, startTime, endTime, gid, uid")
    public ResponseEntity<JsonResult<?>> addProject(Project project) {
        project.setId(10000);
        return new ResponseEntity<>(new JsonResult<>(project, "创建团队项目成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{pid}")
    @ApiOperation(value = "删除团队项目", notes = "url参数: pid")
    public ResponseEntity<JsonResult<?>> deleteProject(@PathVariable int pid) {
        return new ResponseEntity<>(new JsonResult<>(null, "删除团队项目成功"), HttpStatus.OK);
    }

    @GetMapping("/{pid}")
    @ApiOperation(value = "得到用户某一个项目的详细信息", notes = "url参数: pid")
    public ResponseEntity<JsonResult<?>> getUserProject(@PathVariable int pid) {
        List<Project> result = new ArrayList<>();
        Project project = new Project();
        project.setId(10000);
        project.setName("项目管理大作业");
        project.setDescription("如题");
        project.setGid(10000);
        project.setStartTime(new Date());
        project.setEndTime(new Date());
        result.add(project);
        return new ResponseEntity<>(new JsonResult<>(result, "成功得到项目列表"), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "得到用户项目列表", notes = "请求参数待定")
    public ResponseEntity<JsonResult<?>> getUserProjectList() {
        List<Project> result = new ArrayList<>();
        Project project = new Project();
        project.setId(10000);
        project.setName("项目管理大作业");
        project.setDescription("如题");
        project.setGid(10000);
        project.setStartTime(new Date());
        project.setEndTime(new Date());
        result.add(project);
        return new ResponseEntity<>(new JsonResult<>(result, "成功得到项目列表"), HttpStatus.OK);
    }

    @PutMapping("/{pid}")
    @ApiOperation(value = "更新某一个项目的信息", notes = "必填参数：gid, uid. 选填参数:name, description, startTime, endTime. url参数: pid")
    public ResponseEntity<JsonResult<?>> updateProject(@PathVariable int pid, Project project) {
        return new ResponseEntity<>(new JsonResult<>(project, "更新成功"), HttpStatus.OK);
    }


//    @PostMapping("/{pid}/users")
//    @ApiOperation(value = "", notes = "请求参数待定")
//    public ResponseEntity<JsonResult<?>> addUser2Project(@PathVariable int pid, User user) {
//        return new ResponseEntity<>(new JsonResult<>(null, "添加成员成功"), HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{pid}/users/{uid}")
//    public ResponseEntity<JsonResult<?>> removeUserFromProject(@PathVariable int pid, @PathVariable int uid) {
//        return new ResponseEntity<>(new JsonResult<>(null, "删除成员成功"), HttpStatus.OK);
//    }


}
