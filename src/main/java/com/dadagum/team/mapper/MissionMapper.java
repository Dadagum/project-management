package com.dadagum.team.mapper;

import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.query.MissionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MissionMapper {

    void insertMission(Mission mission);

    void deleteProjectById(int mid);

    Mission getMissionById(int mid);

    List<Mission> listUserMission(@Param("uid") int uid, @Param("query") MissionQuery query);

    void updateMission(Mission mission);
}
