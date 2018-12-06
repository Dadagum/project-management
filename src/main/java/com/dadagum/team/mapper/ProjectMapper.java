package com.dadagum.team.mapper;

import com.dadagum.team.common.model.Project;
import com.dadagum.team.common.query.ProjectQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {

    void insertProject(@Param("project") Project project);//

    void deleteProjectById(@Param("pid") int pid);//

    Project getProjectById(@Param("pid") int pid);//

    int getLeaderIdById(@Param("pid")int pid);//

    List<Project> listUserProject(@Param("uid") int uid, @Param("query") ProjectQuery query);//

    void updateProject(@Param("project") Project project);//

    void insertUsersProject(@Param("users") List<Integer> users, @Param("pid") int pid);//

    void deleteUserFromProject(@Param("users") List<Integer> users, @Param("pid") int pid);//
}
