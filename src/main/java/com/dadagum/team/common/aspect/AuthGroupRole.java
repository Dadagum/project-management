package com.dadagum.team.common.aspect;

import com.dadagum.team.common.dto.JwtUserDTO;
import com.dadagum.team.common.model.Group;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AuthGroupRole {



    @Before("com.dadagum.team.common.aspect.SystemPointcut.groupService() && args(userInfo,group,..)")
    public void checkGroupRole(JwtUserDTO userInfo, Group group) {

    }

    @Before("com.dadagum.team.common.aspect.SystemPointcut.groupService() && args(userInfo,gid,..)")
    public void checkGroupRole(JwtUserDTO userInfo, int gid) {

    }
}
