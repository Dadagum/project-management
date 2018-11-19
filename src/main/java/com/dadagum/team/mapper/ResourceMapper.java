package com.dadagum.team.mapper;

import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.query.ResourceQuery;

import java.util.List;

public interface ResourceMapper {

    void insertResource(ProjectResource resource);

    void deleteResourceById(int rid);

    ProjectResource getResourceById(int rid);

    List<ProjectResource> listResource(ResourceQuery query);

    void updateResource(ResourceRecord record);
}
