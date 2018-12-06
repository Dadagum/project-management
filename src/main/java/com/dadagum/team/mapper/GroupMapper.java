package com.dadagum.team.mapper;

import com.dadagum.team.common.model.Group;
import com.dadagum.team.common.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupMapper {

    void insertGroup(@Param("group") Group group);//

    void deleteById(@Param("gid") int gid);//

    Group getGroupById(@Param("gid") int gid);//

    int getLeaderIdById(@Param("gid") int gid);//

    void updateGroup(@Param("group") Group group);//

    List<Integer> listUserGroup(@Param("uid") int uid);//

    void insertUser2Group(@Param("gid") int gid,@Param("uid") int uid);//

    void deleteUserFromGroup(@Param("gid") int gid,@Param("uid") int uid);//

    List<User> listUserTeammate(@Param("gid") int gid,@Param("uid") int uid);//

    int getGidByPid(@Param("pid") int pid);//

    int getGidByMid(@Param("mid") int mid);//


}
