package com.dadagum.team.common.dto;

public class JwtUserInfo {

    private Integer id;
    private String role;

    public JwtUserInfo(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public JwtUserInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
