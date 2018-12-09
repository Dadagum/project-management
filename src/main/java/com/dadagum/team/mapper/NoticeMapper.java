package com.dadagum.team.mapper;

import com.dadagum.team.common.model.ProjectNotice;
import org.apache.ibatis.annotations.Param;

import java.util.List;
public interface NoticeMapper {

    void insertNotice(@Param("notice")ProjectNotice notice);

    List<ProjectNotice> listProjectNotice(@Param("pid")int pid);

    List<ProjectNotice> listUserNotice(@Param("uid")int uid);

    ProjectNotice getNoticeById(@Param("nid")int nid);

    void deleteNotice(@Param("nid")int nid);

    void updateNotice(@Param("notice")ProjectNotice notice);

}
