package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.query.ResourceQuery;
import com.dadagum.team.common.utils.DateUtils;
import com.dadagum.team.mapper.ResourceMapper;
import com.dadagum.team.service.AuthService;
import com.dadagum.team.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    private final ResourceMapper resourceMapper;

    private final AuthService authService;

    @Autowired
    public ResourceServiceImpl(ResourceMapper resourceMapper, AuthService authService) {
        this.resourceMapper = resourceMapper;
        this.authService = authService;
    }

    @Override
    public void insertResource(JwtUserDTO userInfo, ProjectResource resource) {
        authService.checkIfProjectLeader(userInfo.getId(),resource.getPid());
        resource.setCreateTime(DateUtils.getDetialedCurrentTime());
        resourceMapper.insertResource(resource);
        //System.out.println(resource.getId()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ResourceRecord record=new ResourceRecord();
        record.setRid(resource.getId());
        record.setDetails("创建资源");
        record.setNum(resource.getQuantity());
        record.setTime(resource.getCreateTime());
        resourceMapper.insertResourceRecord(record);
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
        authService.checkIfProjectMember(userInfo.getId(),query.getPid());
        List<ProjectResource> result = resourceMapper.listResource(query);
        return result;
    }

    @Override
    public ProjectResource updateResource(JwtUserDTO userInfo, ResourceQuery query) {
        authService.checkIfProjectLeader(userInfo.getId(),query.getPid());
        ResourceRecord record=new ResourceRecord();
        record.setRid(query.getRid());
        record.setDetails(query.getDetails());
        record.setNum(query.getQuantity());
        //System.out.println(record.getNum()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        record.setTime(DateUtils.getDetialedCurrentTime());
        resourceMapper.updateResource(record,record.getRid());
        resourceMapper.insertResourceRecord(record);
        ProjectResource result=resourceMapper.getResourceById(record.getRid());
        return result;
    }
}
