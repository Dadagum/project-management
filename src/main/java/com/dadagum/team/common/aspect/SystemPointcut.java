package com.dadagum.team.common.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 定义整个系统用到的所有切点
 */
@Aspect
public class SystemPointcut {

    @Pointcut("@annotation(com.dadagum.team.common.annotation.CheckGroupRole)")
    public void groupService(){}
}
