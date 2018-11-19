package com.dadagum.team.service;

import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.ResourceQuery;

import java.util.List;

public interface ResourceService {

    void insertResource(JwtUserDTO userInfo, ProjectResource resource);

    void deleteResource(JwtUserDTO userInfo, int rid);

    ProjectResource getResource(JwtUserDTO userInfo, int rid);

    List<ProjectResource> listResource(JwtUserDTO userInfo, ResourceQuery query);

    void updateResource(JwtUserDTO userInfo, ResourceRecord record);
}
