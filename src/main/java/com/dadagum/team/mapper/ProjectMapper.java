package com.dadagum.team.mapper;

import com.dadagum.team.common.model.Project;
import com.dadagum.team.common.query.ProjectQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProjectMapper {

    void insertProject(Project project);

    void deleteProjectById(int gid);

    Project getProjectById(int pid);

    List<Project> listUserProject(@Param("uid") int uid, @Param("query") ProjectQuery query);

    void updateProject(Project project);

    void insertUsersProject(@Param("users") List<Integer> users, @Param("pid") int pid);

    void deleteUserFromProject(@Param("users") List<Integer> users, @Param("pid") int pid);
}
