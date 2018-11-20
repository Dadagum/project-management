package com.dadagum.team.service.impl;

import com.dadagum.team.common.constant.GroupRoleEnum;
import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.exception.def.PermissionDeniedException;
import com.dadagum.team.mapper.GroupMapper;
import com.dadagum.team.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService{

    private final GroupMapper groupMapper;

    @Autowired
    public AuthServiceImpl(GroupMapper groupMapper) {
        this.groupMapper = groupMapper;
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
        if (role != GroupRoleEnum.MEMBER) {
            throw new PermissionDeniedException("您无权操作");
        }
    }

    private GroupRoleEnum getUserGroupRole(int uid, int gid) {
        Integer leaderId = groupMapper.getLeaderIdByUidGid(uid, gid);
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
