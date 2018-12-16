package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.ResourceQuery;
import com.dadagum.team.service.ResourceService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    private final ResourceService resourceService;

    @Autowired
    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @PostMapping
    @ApiOperation(value = "增加项目资源", notes = "必填项目:name,quantity,pid,gid")
    public ResponseEntity<JsonResult<?>> addResource(@RequestAttribute JwtUserDTO userInfo, ProjectResource projectResource) {
        resourceService.insertResource(userInfo, projectResource);
        return ResponseEntity.ok(new JsonResult<>(null, "增加项目资源成功"));
    }

    @DeleteMapping("/{rid}")
    @ApiOperation(value = "删除项目资源", notes = "URL参数rid")
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
    @ApiOperation(value = "查看列表", notes = "必填参数pid")
    public ResponseEntity<JsonResult<?>> listResource(@RequestAttribute JwtUserDTO userInfo, int pid) {
        ResourceQuery query=new ResourceQuery();
        query.setPid(pid);
        List<ProjectResource> result = resourceService.listResource(userInfo, query);
        return ResponseEntity.ok(new JsonResult<>(result, "查看项目资源列表成功"));
    }

    @PutMapping
    @ApiOperation(value = "更新项目资源", notes = "必填参数rid，details，quantity,pid")
    public ResponseEntity<JsonResult<?>> updateResource(@RequestAttribute JwtUserDTO userInfo,@RequestBody ResourceQuery query) {
        //System.out.println(query.toString());
        ProjectResource resource=resourceService.updateResource(userInfo, query);
        return ResponseEntity.ok(new JsonResult<>(resource, "更新资源成功"));
    }

//    @PutMapping
//    @ApiOperation(value = "更新项目资源", notes = "必填参数rid，details，quantity,pid")
//    public ResponseEntity<JsonResult<?>> updateResource(@RequestAttribute JwtUserDTO userInfo, @RequestBody Map<String, String> query) {
//        System.out.println("**************************"+query.get("quantity"));
//        //resourceService.updateResource(userInfo, query);
//        return ResponseEntity.ok(new JsonResult<>(query, "更新资源成功"));
//    }
}
