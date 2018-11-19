package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.ResourceQuery;
import com.dadagum.team.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    public ResponseEntity<JsonResult<?>> addResource(@RequestAttribute JwtUserDTO userInfo, ProjectResource projectResource) {
        resourceService.insertResource(userInfo, projectResource);
        return ResponseEntity.ok(new JsonResult<>(null, "增加项目资源成功"));
    }

    @DeleteMapping("/{rid}")
    public ResponseEntity<JsonResult<?>> deleteResource(@RequestAttribute JwtUserDTO userInfo, @PathVariable int rid) {
        resourceService.deleteResource(userInfo, rid);
        return ResponseEntity.ok(new JsonResult<>(null, "删除项目资源成功"));
    }

    @GetMapping("/{rid}")
    public ResponseEntity<JsonResult<?>> getResource(@RequestAttribute JwtUserDTO userInfo, @PathVariable int rid) {
        ProjectResource resource = resourceService.getResource(userInfo, rid);
        return ResponseEntity.ok(new JsonResult<>(resource, "增加项目资源详细信息成功"));
    }

    @GetMapping
    public ResponseEntity<JsonResult<?>> listResource(@RequestAttribute JwtUserDTO userInfo, ResourceQuery query) {
        List<ProjectResource> result = resourceService.listResource(userInfo, query);
        return ResponseEntity.ok(new JsonResult<>(result, "查看项目资源列表成功"));
    }

    @PutMapping("/{pid}")
    public ResponseEntity<JsonResult<?>> updateResource(@RequestAttribute JwtUserDTO userInfo, ResourceRecord record, @PathVariable int pid) {
        record.setId(pid);
        resourceService.updateResource(userInfo, record);
        return ResponseEntity.ok(new JsonResult<>(record, "更新资源成功"));
    }
}
