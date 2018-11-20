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
    public void insertMission(JwtUserDTO userInfo, Mission mission) {
        authService.checkIfGroupLeader(userInfo.getId(), mission.getGid());
        missionMapper.insertMission(mission);
    }

    @Override
    public void deleteMission(JwtUserDTO userInfo, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfGroupLeader(userInfo.getId(), gid);
    }

    @Override
    public Mission getMission(JwtUserDTO userInfo, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfGroupMember(userInfo.getId(), gid);
        // missionMapper.getMissionById(mid);
        Mission mission = new Mission();
        mission.setId(10000);
        mission.setPid(10000);
        mission.setDetails("参考教学在线");
        mission.setName("编写需求文档");
        mission.setStartTime(new Date());
        mission.setEndTime(new Date());
        return mission;
    }

    @Override
    public List<Mission> listUserMission(JwtUserDTO userInfo, MissionQuery query) {
        if (query.getGid() != null) {
            authService.checkIfGroupMember(userInfo.getId(), query.getGid());
        } else if (query.getPid() != null) {
            int gid = groupService.getGidByPid(query.getPid());
            authService.checkIfGroupMember(userInfo.getId(), gid);
        } else {
            throw new PermissionDeniedException("您无权操作");
        }
        // missionMapper.listUserMission(userInfo.getId(), query);
        List<Mission> result = new ArrayList<>();
        Mission mission = new Mission();
        mission.setId(10000);
        mission.setPid(10000);
        mission.setDetails("参考教学在线");
        mission.setName("编写需求文档");
        mission.setStartTime(new Date());
        mission.setEndTime(new Date());
        result.add(mission);
        return result;
    }

    @Override
    public void updateMission(JwtUserDTO userInfo, Mission mission) {
        authService.checkIfGroupLeader(userInfo.getId(), mission.getGid());
        missionMapper.updateMission(mission);
    }


    @Override
    public void assignUserMission(JwtUserDTO userInfo, List<Integer> users, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        for (int uid : users) {
            authService.checkIfGroupMember(uid, gid);
        }
        missionMapper.insertUsersMission(users, mid);
    }

    @Override
    public void deleteUserMission(JwtUserDTO userInfo, List<Integer> users, int mid) {
        int gid = groupService.getGidByMid(mid);
        authService.checkIfGroupLeader(userInfo.getId(), gid);
        missionMapper.deleteUserFromMission(users, mid);
    }
}
