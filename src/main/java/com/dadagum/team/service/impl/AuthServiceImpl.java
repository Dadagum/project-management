package com.dadagum.team.service.impl;

import com.dadagum.team.common.constant.GroupRoleEnum;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.PermissionDeniedException;
import com.dadagum.team.common.model.Mission;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.mapper.MissionMapper;
import com.dadagum.team.mapper.ProjectMapper;
import com.dadagum.team.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final GroupMapper groupMapper;
    private final ProjectMapper projectMapper;
    private final MissionMapper missionMapper;

    @Autowired
    public AuthServiceImpl(GroupMapper groupMapper, ProjectMapper projectMapper, MissionMapper missionMapper) {
        this.groupMapper = groupMapper;
        this.projectMapper = projectMapper;
        this.missionMapper = missionMapper;
    }

    @Override
    public void checkIfGroupLeader(int uid, int gid) {
        GroupRoleEnum role = getUserGroupRole(uid, gid);
        if (role != GroupRoleEnum.LEADER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    @Override
    public void checkIfGroupMember(int uid, int gid){
        GroupRoleEnum role = getUserGroupRole(uid, gid);
        if (role == GroupRoleEnum.STRANGER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    @Override
    public void checkIfProjectMember(int uid, int pid) {
        GroupRoleEnum role =getUserProjectRole(uid,pid);
        if (role == GroupRoleEnum.STRANGER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    @Override
    public void checkIfProjectLeader(int uid, int pid) {
        GroupRoleEnum role = getUserProjectRole(uid, pid);
        if (role != GroupRoleEnum.LEADER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    @Override
    public void checkIfMissionMember(int uid, int mid) {
        GroupRoleEnum role=getUserMissionRole(uid,mid);
        if (role == GroupRoleEnum.STRANGER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    @Override
    public void checkIfMissionLeader(int uid, int mid) {
        GroupRoleEnum role = getUserMissionRole(uid, mid);
        if (role != GroupRoleEnum.LEADER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    private GroupRoleEnum getUserGroupRole(int uid, int gid) {
        Integer leaderId = groupMapper.getLeaderIdById(gid);
        if (leaderId == null) { // 说明不属于这个组
            return GroupRoleEnum.STRANGER;
        } else {
            if (leaderId.intValue() == uid) { // 说明是队长
                return GroupRoleEnum.LEADER;
            } else { // 普通组员
                return GroupRoleEnum.MEMBER;
            }
        }
    }

    private GroupRoleEnum getUserProjectRole(int uid,int pid){
        Integer leaderId = projectMapper.getLeaderIdById(pid);
        if (leaderId == null) { // 说明不属于这个组
            return GroupRoleEnum.STRANGER;
        } else {
            if (leaderId.intValue() == uid) { // 说明是队长
                return GroupRoleEnum.LEADER;
            } else { // 普通组员
                return GroupRoleEnum.MEMBER;
            }
        }
    }


    private GroupRoleEnum getUserMissionRole(int uid,int mid){
        Integer leaderId=missionMapper.getLeaderById(mid);
        if (leaderId == null) { // 说明不属于这个组
            return GroupRoleEnum.STRANGER;
        } else {
            if (leaderId.intValue() == uid) { // 说明是队长
                return GroupRoleEnum.LEADER;
            } else { // 普通组员
                return GroupRoleEnum.MEMBER;
            }
        }
    }
}
