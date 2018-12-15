package com.dadagum.team.mapper;

import com.dadagum.team.common.model.ProjectResource;
import com.dadagum.team.common.model.ResourceRecord;
import com.dadagum.team.common.query.ResourceQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ResourceMapper {

    void insertResource(@Param("resource") ProjectResource resource);

    void deleteResourceById(@Param("rid")int rid);

    ProjectResource getResourceById(@Param("rid")int rid);

    List<ProjectResource> listResource(@Param("query")ResourceQuery query);

    void updateResource(@Param("record")ResourceRecord record,@Param("rid")int rid);

    void insertResourceRecord(@Param("record") ResourceRecord record);

    List<ResourceRecord> listResourceRecord(@Param("rid") int rid);
}
