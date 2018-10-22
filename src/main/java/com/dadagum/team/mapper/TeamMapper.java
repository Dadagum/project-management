package com.dadagum.team.mapper;

import com.dadagum.team.common.bean.Team;

import java.util.List;

public interface TeamMapper {

    public void insert(Team team);

    public void deleteById(int id);

    public Team selectById(int id);

    public void update(Team team);

    public List<Integer> getUserTeams(int uid);

}
