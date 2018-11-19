package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.ResourceQuery;
import com.dadagum.team.common.utils.DateUtils;
import com.dadagum.team.mapper.ResourceMapper;
import com.dadagum.team.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceMapper resourceMapper;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper) {
        this.resourceMapper = resourceMapper;
    }

    @Override
    public void insertResource(JwtUserDTO userInfo, ProjectResource resource) {
        resourceMapper.insertResource(resource);
    }

    @Override
    public void deleteResource(JwtUserDTO userInfo, int rid) {
        resourceMapper.deleteResourceById(rid);
    }

    @Override
    public ProjectResource getResource(JwtUserDTO userInfo, int rid) {
       // resourceMapper.getResourceById(rid);
        ProjectResource resource = new ProjectResource();
        resource.setCreateTime(DateUtils.getDetialedCurrentTime());
        resource.setId(10000);
        resource.setName("钱");
        resource.setQuantity(100000000);
        resource.setPid(10000);
        return resource;
    }

    @Override
    public List<ProjectResource> listResource(JwtUserDTO userInfo, ResourceQuery query) {
        // resourceMapper.listResource(query);
        List<ProjectResource> result = new ArrayList<>();
        ProjectResource resource = new ProjectResource();
        resource.setCreateTime(DateUtils.getDetialedCurrentTime());
        resource.setId(10000);
        resource.setName("钱");
        resource.setQuantity(100000000);
        resource.setPid(10000);
        result.add(resource);
        return result;
    }

    @Override
    public void updateResource(JwtUserDTO userInfo, ResourceRecord record) {
        resourceMapper.updateResource(record);
    }
}
