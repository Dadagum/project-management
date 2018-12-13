package com.dadagum.team.service;

import com.dadagum.team.common.model.Group;
import com.dadagum.team.common.model.User;
import com.dadagum.team.common.dto.JwtUserDTO;

import java.util.List;

public interface GroupService {

    Group insertGroup(Group group, JwtUserDTO userInfo);

    void deleteGroup(int gid, JwtUserDTO userInfo);

    Group getGroup(int gid, JwtUserDTO userInfo);

    void updateGroup(Group group, JwtUserDTO userInfo);

    List<Group> listGroup(JwtUserDTO userInfo);

    void insertUser2Group(JwtUserDTO userInfo, int gid, int uid);

    void deleteUserFromGroup(JwtUserDTO userInfo, int gid, int uid);

    List<User> listUserTeammate(JwtUserDTO userInfo, int gid);

    int getGidByPid(int pid);

    int getGidByMid(int mid);


}
