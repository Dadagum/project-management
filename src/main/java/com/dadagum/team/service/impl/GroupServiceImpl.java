package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.Group;
import com.dadagum.team.common.model.User;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.service.AuthService;
import com.dadagum.team.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private final GroupMapper groupMapper;

    private final AuthService authService;

    @Autowired
    public GroupServiceImpl(GroupMapper groupMapper, AuthService authService) {
        this.groupMapper = groupMapper;
        this.authService = authService;
    }

    @Override
    public void insertGroup(Group group) {
        groupMapper.insertGroup(group);
    }

    @Override
    public void deleteGroup(int gid, JwtUserDTO userInfo) {
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        groupMapper.deleteById(gid);
    }

    @Override
    public Group getGroup(int gid, JwtUserDTO userInfo) {
        authService.checkIfGroupMember(userInfo.getId(), gid);

        groupMapper.getGroupById(gid);
        // 暂时返回
        Group result = new Group(10000, "朱世靖小分队", 10000, new Date());
        return result;
    }

    @Override
    public void updateGroup(Group group, JwtUserDTO userInfo) {
        authService.checkIfGroupLeader(userInfo.getId(), group.getId());
        groupMapper.updateGroup(group);
    }

    @Override
    public List<Group> listGroup(JwtUserDTO userInfo) {
        //groupMapper.listUserGroup(userInfo.getId());
        // 暂时返回
        List<Group> result = new ArrayList<>();
        Group group = new Group(10000, "朱世靖小分队", 10000, new Date());
        result.add(group);
        return result;
    }

    @Override
    public void insertUser2Group(JwtUserDTO userInfo, int gid, int uid) {
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        groupMapper.insertUser2Group(gid, uid);
    }

    @Override
    public void deleteUserFromGroup(JwtUserDTO userInfo, int gid, int uid) {
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        groupMapper.deleteUserFromGroup(gid, uid);
    }

    @Override
    public List<User> listUserTeammate(JwtUserDTO userInfo, int gid) {
        authService.checkIfGroupMember(userInfo.getId(), gid);
        return groupMapper.listUserTeammate(gid, userInfo.getId());
    }

    @Override
    public int getGidByPid(int pid) {
        return groupMapper.getGidByPid(pid);
    }

    @Override
    public int getGidByMid(int mid) {
        return groupMapper.getGidByMid(mid);
    }


}
