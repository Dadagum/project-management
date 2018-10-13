package com.dadagum.team.service;

import com.dadagum.team.bean.Team;

public interface TeamService {

    public void add(Team team);

    public void delete(int id);

    public Team get(int id);

    public void update(Team team);
}
