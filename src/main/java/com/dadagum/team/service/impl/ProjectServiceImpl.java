package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.Project;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.PermissionDeniedException;
import com.dadagum.team.common.query.ProjectQuery;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.mapper.ProjectMapper;
import com.dadagum.team.service.AuthService;
import com.dadagum.team.service.GroupService;
import com.dadagum.team.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    private final AuthService authService;

    private final GroupService groupService;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper, AuthService authService, GroupService groupService) {
        this.projectMapper = projectMapper;
        this.authService = authService;
        this.groupService = groupService;
    }

    @Override
    public void insertProject(JwtUserDTO userInfo, Project project) {
        authService.checkIfGroupLeader(userInfo.getId(), project.getGid());
        projectMapper.insertProject(project);
    }

    @Override
    public void deleteProject(JwtUserDTO userInfo, int pid) {
        Integer gid = groupService.getGidByPid(pid);
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        projectMapper.deleteProjectById(pid);

    }

    @Override
    public Project getProject(JwtUserDTO userInfo, int pid) {
        Integer gid = groupService.getGidByPid(pid);
        authService.checkIfGroupMember(userInfo.getId(), gid);
        // projectMapper.getProjectById(pid);
        Project project = new Project();
        project.setId(10000);
        project.setName("项目管理大作业");
        project.setDescription("如题");
        project.setGid(10000);
        project.setStartTime("");
        project.setEndTime("");
        return project;
    }

    @Override
    public List<Project> listUserProject(JwtUserDTO userInfo, ProjectQuery query) {
        authService.checkIfGroupMember(userInfo.getId(), query.getGid());
        // projectMapper.listUserProject(userInfo.getId(), query);
        List<Project> result = new ArrayList<>();
        Project project = new Project();
        project.setId(10000);
        project.setName("项目管理大作业");
        project.setDescription("如题");
        project.setGid(10000);
        project.setStartTime("");
        project.setEndTime("");
        result.add(project);
        return result;
    }

    @Override
    public void updateProject(JwtUserDTO userInfo, Project project) {
        authService.checkIfGroupLeader(userInfo.getId(), project.getGid());
        projectMapper.updateProject(project);
    }

    @Override
    public void assignUserProject(JwtUserDTO userInfo, List<Integer> users, int pid) {
        Integer gid = groupService.getGidByPid(pid);
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        for (int uid : users) {
            authService.checkIfGroupMember(uid, gid);
        }
        projectMapper.insertUsersProject(users, pid);
    }

    @Override
    public void deleteUserFromProject(JwtUserDTO userInfo, List<Integer> users, int pid) {
        Integer gid = groupService.getGidByPid(pid);
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        projectMapper.deleteUserFromProject(users, pid);
    }
}
