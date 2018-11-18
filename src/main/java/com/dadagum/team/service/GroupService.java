package com.dadagum.team.service;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.bean.User;
import com.dadagum.team.common.dto.JwtUserDTO;

import java.util.List;

public interface GroupService {

    void insertGroup(Group group);

    void deleteGroup(int id, JwtUserDTO userInfo);

    Group getGroup(int id, JwtUserDTO userInfo);

    void updateGroup(Group group, JwtUserDTO userInfo);

    List<Group> listGroup(JwtUserDTO userInfo);

    void insertUser2Group(JwtUserDTO userInfo, int gid, int uid);

    void deleteUserFromGroup(JwtUserDTO userInfo, int gid, int uid);

    List<User> listUserTeammate(JwtUserDTO userInfo, int gid);

}
