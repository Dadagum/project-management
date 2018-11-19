package com.dadagum.team.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value="Mission",description="团队任务")
public class Mission {

    @ApiModelProperty(value="任务id",name="id")
    private Integer id;

    @ApiModelProperty(value="团队项目id",name="pid")
    private Integer pid;

    @ApiModelProperty(value="任务名称(长度 1-20)",name="name")
    private String name;

    @ApiModelProperty(value="任务描述(200字以内)",name="details")
    private String details;

    @ApiModelProperty(value="任务开始时间(yyyy-MM-dd)",name="startTime")
    private Date startTime;

    @ApiModelProperty(value="任务结束时间(yyyy-MM-dd)",name="endTime")
    private Date endTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
