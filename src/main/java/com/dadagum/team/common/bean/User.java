package com.dadagum.team.common.bean;

import com.fasterxml.jackson.annotation.JsonView;

import java.util.Date;

public class User {

    private Integer id;
    private String userName;
    private String password;
    private String phone;
    private String role;
    private String salt;
    private Date createTime;

    public interface PersonalUserInfo extends PublicUserInfo{}
    public interface PublicUserInfo {}

    public User(String userName, String role) {
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    @JsonView(PublicUserInfo.class)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @JsonView(PublicUserInfo.class)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @JsonView(PersonalUserInfo.class)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @JsonView(PublicUserInfo.class)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
