package com.dadagum.team.service.impl;

import com.dadagum.team.common.bean.Project;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.PermissionDeniedException;
import com.dadagum.team.common.query.ProjectQuery;
import com.dadagum.team.mapper.ProjectMapper;
import com.dadagum.team.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectMapper projectMapper;

    @Autowired
    public ProjectServiceImpl(ProjectMapper projectMapper) {
        this.projectMapper = projectMapper;
    }

    @Override
    public void insertProject(JwtUserDTO userInfo, Project project) {
        if (ifUserGroupLeader(userInfo.getId(), project.getGid())) {
            projectMapper.insertProject(project);
            return;
        }
        throw new PermissionDeniedException("您无权限操作");
    }

    @Override
    public void deleteProject(JwtUserDTO userInfo, int pid) {
        if (ifUserGroupLeader(userInfo.getId(), pid)) {
            projectMapper.deleteProjectById(pid);
            return;
        }
        throw new PermissionDeniedException("您无权限操作");
    }

    @Override
    public Project getProject(JwtUserDTO userInfo, int pid) {
        // projectMapper.getProjectById(pid);
        Project project = new Project();
        project.setId(10000);
        project.setName("项目管理大作业");
        project.setDescription("如题");
        project.setGid(10000);
        project.setStartTime(new Date());
        project.setEndTime(new Date());
        return project;
    }

    @Override
    public List<Project> listUserProject(JwtUserDTO userInfo, ProjectQuery query) {
        // projectMapper.listUserProject(userInfo.getId(), query);
        List<Project> result = new ArrayList<>();
        Project project = new Project();
        project.setId(10000);
        project.setName("项目管理大作业");
        project.setDescription("如题");
        project.setGid(10000);
        project.setStartTime(new Date());
        project.setEndTime(new Date());
        result.add(project);
        return result;
    }

    @Override
    public void updateProject(JwtUserDTO userInfo, Project project) {
        projectMapper.updateProject(project);
    }

    @Override
    public void assignUserProject(JwtUserDTO userInfo, List<Integer> users, int pid) {
        projectMapper.insertUsersProject(users, pid);
    }

    @Override
    public void deleteUserFromProject(JwtUserDTO userInfo, List<Integer> users, int pid) {
        projectMapper.deleteUserFromProject(users, pid);
    }

    private boolean ifUserGroupLeader(int uid, int gid) {
        return true;
    }
}
