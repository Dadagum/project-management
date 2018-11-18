package com.dadagum.team.common.dto;

public class JwtUserDTO {

    private Integer id;
    private String role;

    public JwtUserDTO(Integer id, String role) {
        this.id = id;
        this.role = role;
    }

    public JwtUserDTO() {
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
