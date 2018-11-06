package com.dadagum.team.controller;

import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.bean.Mission;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/missions")
@Api(tags = {"项目任务模块功能相关接口"})
public class MissionController {

    @PostMapping
    @ApiOperation(value = "增加团队项目任务", notes = "必填字段: pid, name, details, startTime, endTime")
    public ResponseEntity<JsonResult<?>> addMission(Mission mission){
        mission.setId(10000);
        mission.setPid(mission.getPid());
        return new ResponseEntity<>(new JsonResult<>(mission, "增加任务成功"), HttpStatus.OK);
    }

    @DeleteMapping("/{mid}")
    @ApiOperation(value = "删除团队项目任务", notes = "url参数： 任务id")
    public ResponseEntity<JsonResult<?>> deleteMission(@PathVariable int mid){
        return new ResponseEntity<>(new JsonResult<>(null, "删除任务成功"), HttpStatus.OK);
    }

    @GetMapping("/{mid}")
    @ApiOperation(value = "得到团队项目某一个任务详细信息", notes = "url参数： 任务id")
    public ResponseEntity<JsonResult<?>> getProjectMission(@PathVariable int mid){
        Mission mission = new Mission();
        mission.setId(10000);
        mission.setPid(10000);
        mission.setDetails("参考教学在线");
        mission.setName("编写需求文档");
        mission.setStartTime(new Date());
        mission.setEndTime(new Date());
        return new ResponseEntity<>(new JsonResult<>(mission, "创建任务成功"), HttpStatus.OK);
    }

    @GetMapping
    @ApiOperation(value = "得到团队项目中的任务列表", notes = "必填参数：待定")
    public ResponseEntity<JsonResult<?>> getProjectMissionList(){
        Mission mission = new Mission();
        mission.setId(10000);
        mission.setPid(10000);
        mission.setDetails("参考教学在线");
        mission.setName("编写需求文档");
        mission.setStartTime(new Date());
        mission.setEndTime(new Date());
        return new ResponseEntity<>(new JsonResult<>(mission, "创建任务成功"), HttpStatus.OK);
    }

    @PutMapping("/{mid}")
    @ApiOperation(value = "更新团队项目任务信息", notes = "选填参数：pid, name, details, startTime, endTime. url参数： 任务id")
    public ResponseEntity<JsonResult<?>> updateMission(Mission mission, @PathVariable int mid){
        mission.setId(10000);
        mission.setPid(10000);
        return new ResponseEntity<>(new JsonResult<>(mission, "创建任务成功"), HttpStatus.OK);
    }
}
