package com.dadagum.team.service.impl;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Override
    public void add(Group group) {
        groupMapper.insert(group);
    }

    @Override
    public void delete(int id) {
        groupMapper.deleteById(id);
    }

    @Override
    public Group get(int id) {
        return groupMapper.selectById(id);
    }

    @Override
    public void update(Group group) {
        groupMapper.update(group);
    }
}
