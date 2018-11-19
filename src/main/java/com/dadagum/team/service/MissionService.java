package com.dadagum.team.service;

import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.MissionQuery;

import java.util.List;

public interface MissionService {

    void insertProject(JwtUserDTO userInfo, Mission mission);

    void deleteProject(JwtUserDTO userInfo, int mid);

    Mission getMission(JwtUserDTO userInfo, int mid);

    List<Mission> listUserMission(JwtUserDTO userInfo, MissionQuery query);

    void updateProject(JwtUserDTO userInfo, Mission mission);
}
