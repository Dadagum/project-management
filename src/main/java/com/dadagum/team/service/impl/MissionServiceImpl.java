package com.dadagum.team.service.impl;

import com.dadagum.team.common.model.Mission;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.query.MissionQuery;
import com.dadagum.team.mapper.MissionMapper;
import com.dadagum.team.service.MissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class MissionServiceImpl implements MissionService{

    private final MissionMapper missionMapper;

    @Autowired
    public MissionServiceImpl(MissionMapper missionMapper) {
        this.missionMapper = missionMapper;
    }

    @Override
    public void insertProject(JwtUserDTO userInfo, Mission mission) {
        missionMapper.insertMission(mission);
    }

    @Override
    public void deleteProject(JwtUserDTO userInfo, int mid) {
        missionMapper.deleteProjectById(mid);
    }

    @Override
    public Mission getMission(JwtUserDTO userInfo, int mid) {
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
    public void updateProject(JwtUserDTO userInfo, Mission mission) {
        missionMapper.updateMission(mission);
    }
}
