package com.dadagum.team.service;

import com.dadagum.team.common.model.Project;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.ProjectQuery;

import java.util.List;

public interface ProjectService {

    void insertProject(JwtUserDTO userInfo, Project project);

    void deleteProject(JwtUserDTO userInfo, int pid);

    Project getProject(JwtUserDTO userInfo, int pid);

    List<Project> listUserProject(JwtUserDTO userInfo, ProjectQuery query);

    void updateProject(JwtUserDTO userInfo, Project project);

    void assignUserProject(JwtUserDTO userInfo, List<Integer> users, int pid);

    void deleteUserFromProject(JwtUserDTO userInfo, List<Integer> users, int pid);
}
