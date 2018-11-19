package com.dadagum.team.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="Group",description="团队")
public class Group {

    @ApiModelProperty(value="团队id",name="id")
    private Integer id;

    @ApiModelProperty(value="团队名称(长度 1-20)",name="name")
    private String name;

    @ApiModelProperty(value="团队队长id",name="uid")
    private Integer uid;

    @ApiModelProperty(value="团队创建时间(yyyy-MM-dd HH:mm:ss)",name="createTime")
    private Date createTime;

    public Group(Integer id, String name, Integer uid, Date createTime) {
        this.id = id;
        this.name = name;
        this.uid = uid;
        this.createTime = createTime;
    }

    public Group() {
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

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
