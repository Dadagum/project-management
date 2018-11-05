package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Project;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/groups")
public class ProjectController {

    @PostMapping("/{gid}/projects")
    public ResponseEntity<JsonResult<?>> add(@PathVariable int gid,  Project project) {
        project.setId(10000);
        return new ResponseEntity<>(new JsonResult<>(project, "创建成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{id}/projects")
    public ResponseEntity<JsonResult<?>> delete(@PathVariable int id, Project project) {
        return new ResponseEntity<>(new JsonResult<>(project, "删除成功"), HttpStatus.OK);
    }


}
