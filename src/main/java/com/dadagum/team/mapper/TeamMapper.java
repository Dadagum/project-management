package com.dadagum.team.mapper;

import com.dadagum.team.bean.Team;

public interface TeamMapper {

    public void insert(Team team);

    public void deleteById(int id);

    public Team selectById(int id);

    public void update(Team team);
}
