package com.dadagum.team.controller;

import com.dadagum.team.bean.Team;
import com.dadagum.team.common.api.JsonResult;
import com.dadagum.team.common.constant.JsonCode;
import com.dadagum.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired
    private TeamService teamService;

    @PostMapping("/")
    public JsonResult<?> add(Team team){
        teamService.add(team);
        return new JsonResult<>(team, "增加团队成功", JsonCode.SUCCESS);
    }

    @DeleteMapping("/")
    public JsonResult<?> delete(int id){
        teamService.delete(id);
        return new JsonResult<>(null, "删除团队成功", JsonCode.SUCCESS);
    }

    @GetMapping("/{id}")
    public JsonResult<?> get(@PathVariable int id){
        Team result = teamService.get(id);
        return new JsonResult<>(result, "得到团队信息成功", JsonCode.SUCCESS);
    }

    @PutMapping("/")
    public JsonResult<?> update(Team team){
        teamService.update(team);
        return new JsonResult<>(team, "更新团队信息成功", JsonCode.SUCCESS);
    }
}
