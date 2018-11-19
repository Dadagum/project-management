package com.dadagum.team.common.model;

public enum Role {

    USER(1, "user"),
    ADMIN(2, "admin"),
    ROOT(3, "root");

    private Integer id;
    private String name;

    private Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public String value() {
        return this.name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
