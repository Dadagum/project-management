package com.dadagum.team.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value="Project",description="团队项目")
public class Project {

    @ApiModelProperty(value="团队项目id",name="id")
    private Integer id;

    @ApiModelProperty(value="项目名称(长度 1-20)",name="name")
    private String name;

    @ApiModelProperty(value="项目描述(200字内)",name="name")
    private String description;

    @ApiModelProperty(value="项目开始时间(yyyy-MM-dd)",name="startTime")
    private String startTime;

    @ApiModelProperty(value="项目结束时间(yyyy-MM-dd)",name="startTime")
    private String endTime;

    @ApiModelProperty(value="团队id",name="gid")
    private Integer gid;

    private Integer uid;

    @ApiModelProperty(value="项目完成情况",name="finish")
    private boolean finish;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Integer getUid() { return uid; }

    public void setUid(Integer uid) { this.uid = uid; }
}
