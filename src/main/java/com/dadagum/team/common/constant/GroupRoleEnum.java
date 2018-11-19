package com.dadagum.team.common.constant;

public enum GroupRoleEnum {

    MEMBER(0),   // 普通成员
    LEADER(1);   // 队长

    private Integer value;

    private GroupRoleEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
