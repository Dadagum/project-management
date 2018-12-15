package com.dadagum.team.service.impl;

import com.dadagum.team.common.exception.def.PermissionDeniedException;
import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.MissionQuery;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.mapper.MissionMapper;
import com.dadagum.team.service.AuthService;
import com.dadagum.team.service.GroupService;
import com.dadagum.team.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MissionServiceImpl implements MissionService{

    private final MissionMapper missionMapper;

    private final AuthService authService;

    private final GroupService groupService;

    @Autowired
    public MissionServiceImpl(MissionMapper missionMapper,  GroupService groupService, AuthService authService) {
        this.missionMapper = missionMapper;
        this.groupService = groupService;
        this.authService = authService;
    }

    @Override
    public Mission insertMission(JwtUserDTO userInfo, Mission mission) {
        authService.checkIfGroupLeader(userInfo.getId(), mission.getPid());
        missionMapper.insertMission(mission);
        missionMapper.insertUsersMission(mission.getUid(),mission.getId());
        return  mission;
    }

    @Override
    public void deleteMission(JwtUserDTO userInfo, int mid) {
        authService.checkIfMissionLeader(userInfo.getId(), mid);
        missionMapper.deleteMissionById(mid);
    }

    @Override
    public Mission getMission(JwtUserDTO userInfo, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfGroupMember(userInfo.getId(), gid);
        Mission mission = missionMapper.getMissionById(mid);
        return mission;
    }

    @Override
    public List<Mission> listUserMission(JwtUserDTO userInfo, MissionQuery query) {
        if (query.getGid() != null) {
            authService.checkIfGroupMember(userInfo.getId(), query.getGid());
        } else if (query.getPid() != null) {
            int gid = groupService.getGidByPid(query.getPid());
            authService.checkIfGroupMember(userInfo.getId(), gid);
        }
        List<Mission> result = missionMapper.listUserMission(query);
        return result;
    }

    @Override
    public void updateMission(JwtUserDTO userInfo, Mission mission) {
        authService.checkIfMissionLeader(userInfo.getId(), mission.getId());
        missionMapper.updateMission(mission);
    }


    @Override
    public void assignUserMission(JwtUserDTO userInfo, List<Integer> users, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfMissionLeader(userInfo.getId(), mid);
        for (int uid : users) {
            authService.checkIfGroupMember(uid, gid);
            missionMapper.insertUsersMission(uid, mid);
        }
    }

    @Override
    public void deleteUserMission(JwtUserDTO userInfo, List<Integer> users, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfMissionLeader(userInfo.getId(), mid);
        for (int uid : users) {
            missionMapper.deleteUserFromMission(uid, mid);
        }

    }
}
