package com.dadagum.team.service.impl;

import com.dadagum.team.bean.Team;
import com.dadagum.team.mapper.TeamMapper;
import com.dadagum.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

    @Autowired
    private TeamMapper teamMapper;

    @Override
    public void add(Team team) {
        teamMapper.insert(team);
    }

    @Override
    public void delete(int id) {
        teamMapper.deleteById(id);
    }

    @Override
    public Team get(int id) {
        return teamMapper.selectById(id);
    }

    @Override
    public void update(Team team) {
        teamMapper.update(team);
    }
}
