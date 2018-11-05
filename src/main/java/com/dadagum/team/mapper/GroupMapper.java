package com.dadagum.team.mapper;

import com.dadagum.team.common.bean.Group;

import java.util.List;

public interface GroupMapper {

    public void insert(Group group);

    public void deleteById(int id);

    public Group selectById(int id);

    public void update(Group group);

    public List<Integer> getUserTeams(int uid);

}
