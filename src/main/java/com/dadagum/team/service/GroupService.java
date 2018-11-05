package com.dadagum.team.service;

import com.dadagum.team.common.bean.Group;

public interface GroupService {

    public void add(Group group);

    public void delete(int id);

    public Group get(int id);

    public void update(Group group);
}
