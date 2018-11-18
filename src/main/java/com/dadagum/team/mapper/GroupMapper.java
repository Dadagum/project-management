package com.dadagum.team.mapper;

import com.dadagum.team.common.bean.Group;
import com.dadagum.team.common.bean.User;

import java.util.List;

public interface GroupMapper {

    void insertGroup(Group group);

    void deleteById(int gid);

    Group getGroupById(int gid);

    void updateGroup(Group group);

    List<Integer> listUserGroup(int uid);

    void insertUser2Group(int gid, int uid);

    void deleteUserFromGroup(int gid, int uid);

    List<User> listUserTeammate(int gid, int uid);
}
