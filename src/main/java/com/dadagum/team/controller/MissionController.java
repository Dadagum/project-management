package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.MissionQuery;
import com.dadagum.team.service.MissionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/missions")
@Api(tags = {"项目任务模块功能相关接口"})
public class MissionController {

    private final MissionService missionService;

    @Autowired
    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    @PostMapping
    @ApiOperation(value = "增加团队项目任务", notes = "必填字段: pid, name, details, startTime, endTime")
    public ResponseEntity<JsonResult<?>> addMission(Mission mission, @RequestAttribute JwtUserDTO userInfo){
        missionService.insertMission(userInfo, mission);
        mission.setId(10000);
        mission.setPid(mission.getPid());
        return ResponseEntity.ok(new JsonResult<>(mission, "增加任务成功"));
    }

    @DeleteMapping("/{mid}")
    @ApiOperation(value = "删除团队项目任务", notes = "url参数： 任务id")
    public ResponseEntity<JsonResult<?>> deleteMission(@PathVariable int mid, @RequestAttribute JwtUserDTO userInfo){
        missionService.deleteMission(userInfo, mid);
        return ResponseEntity.ok(new JsonResult<>(null, "删除任务成功"));
    }

    @GetMapping("/{mid}")
    @ApiOperation(value = "得到团队项目某一个任务详细信息", notes = "url参数： 任务id")
    public ResponseEntity<JsonResult<?>> getProjectMission(@PathVariable int mid, @RequestAttribute JwtUserDTO userInfo){
        Mission mission = missionService.getMission(userInfo, mid);
        return ResponseEntity.ok(new JsonResult<>(mission, "查看任务成功"));
    }

    @GetMapping
    @ApiOperation(value = "得到团队项目中的任务列表", notes = "必填参数：待定")
    public ResponseEntity<JsonResult<?>> listProjectMission(@RequestAttribute JwtUserDTO userInfo, MissionQuery query){
        List<Mission> result = missionService.listUserMission(userInfo, query);
        return ResponseEntity.ok(new JsonResult<>(result, "查看任务列表成功"));
    }

    @PutMapping("/{mid}")
    @ApiOperation(value = "更新团队项目任务信息", notes = "选填参数：pid, name, details, startTime, endTime. url参数： 任务id")
    public ResponseEntity<JsonResult<?>> updateMission(Mission mission, @PathVariable int mid, @RequestAttribute JwtUserDTO userInfo){
        mission.setId(mid);
        mission.setPid(10000);
        missionService.updateMission(userInfo, mission);
        return ResponseEntity.ok(new JsonResult<>(mission, "创建任务成功"));
    }

    @PostMapping("/{mid}/users")
    public ResponseEntity<JsonResult<?>> assignUserMission(@PathVariable int mid, @RequestBody Map<String, List<Integer>> map, @RequestAttribute JwtUserDTO userInfo){
        List<Integer> users = map.get("users");

    }

    @DeleteMapping("/{mid}/users")
    public ResponseEntity<JsonResult<?>> assignUserMission(@PathVariable int mid, @RequestBody Map<String, List<Integer>> map, @RequestAttribute JwtUserDTO userInfo){
        List<Integer> users = map.get("users");

    }

}
