package com.dadagum.team.service;

import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.model.User;
import com.dadagum.team.common.query.MissionQuery;

import java.util.List;

public interface MissionService {

    Mission insertMission(JwtUserDTO userInfo, Mission mission);

    void deleteMission(JwtUserDTO userInfo, int mid);

    Mission getMission(JwtUserDTO userInfo, int mid);

    List<Mission> listUserMission(JwtUserDTO userInfo, MissionQuery query);

    void updateMission(JwtUserDTO userInfo, Mission mission);

    void assignUserMission(JwtUserDTO userInfo, List<Integer> users, int mid);

    void deleteUserMission(JwtUserDTO userInfo, List<Integer> users, int mid);

    List<User> listUser(int mid, JwtUserDTO userInfo);
}
