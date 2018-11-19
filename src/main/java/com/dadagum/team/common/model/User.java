package com.dadagum.team.common.model;

import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="User",description="用户")
public class User {

    @ApiModelProperty(value="用户id",name="id")
    private Integer id;

    @ApiModelProperty(value="用户名称(长度 1-20)",name="userName")
    private String userName;

    @ApiModelProperty(value="用户密码(长度 5-30)",name="password")
    private String password;

    @ApiModelProperty(value="用户手机",name="phone")
    private String phone;

    @ApiModelProperty(value="用户在系统中扮演角色",name="role")
    private String role;

    private String salt;

    private Date createTime;

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
