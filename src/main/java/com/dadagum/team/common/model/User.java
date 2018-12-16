package com.dadagum.team.common.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


public class User {

    private Integer id;
    private String userName;
    private String password;
    private String phone;
    private String role;
    private String salt;
    private String createTime;

    public User(String userName, String password, String phone, String role, String salt, String createTime) {
        this.userName = userName;
        this.password = password;
        this.phone = phone;
        this.role = role;
        this.salt = salt;
        this.createTime = createTime;
    }

    /**
     * + phone
     */
    public interface PersonalUserInfo extends PublicUserInfo{}

    /**
     * id, userName, role
     */
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", role='" + role + '\'' +
                ", salt='" + salt + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}
