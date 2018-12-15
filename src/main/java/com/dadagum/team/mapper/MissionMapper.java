package com.dadagum.team.mapper;

import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.query.MissionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MissionMapper {

    void insertMission(@Param("mission") Mission mission);

    void deleteMissionById(@Param("mid")int mid);

    Mission getMissionById(@Param("mid") int mid);

    int getLeaderById(@Param("mid") int mid);

    List<Mission> listUserMission(@Param("query") MissionQuery query);

    void updateMission(@Param("mission") Mission mission);

    void insertUsersMission(@Param("uid") Integer uid, @Param("mid") int mid);

    void deleteUserFromMission(@Param("uid") Integer uid, @Param("mid") int mid);
}
