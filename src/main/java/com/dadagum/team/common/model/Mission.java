package com.dadagum.team.common.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



@ApiModel(value="Mission",description="团队任务")
public class Mission {

    @ApiModelProperty(value="任务id",name="id")
    private Integer id;

    @ApiModelProperty(value="团队项目id",name="pid")
    private Integer pid;

    private Integer gid;

    private Integer uid;

    @ApiModelProperty(value="任务名称(长度 1-20)",name="name")
    private String name;

    @ApiModelProperty(value="任务描述(200字以内)",name="details")
    private String details;

    @ApiModelProperty(value="任务开始时间(yyyy-MM-dd)",name="startTime")
    private String startTime;

    @ApiModelProperty(value="任务结束时间(yyyy-MM-dd)",name="endTime")
    private String endTime;

    private boolean finished;

    private boolean overdued;

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

    public Integer getGid() { return gid; }

    public void setGid(Integer gid) { this.gid = gid; }

    public Integer getUid() { return uid; }

    public void setUid(Integer uid) { this.uid = uid; }

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

    public boolean isFinished() { return finished; }

    public void setFinished(boolean finished) { this.finished = finished; }

    public boolean isOverdued() { return overdued; }

    public void setOverdued(boolean overdued) { this.overdued = overdued; }

    @Override
    public String toString() {
        return "Mission{" +
                "id=" + id +
                ", pid=" + pid +
                ", gid=" + gid +
                ", uid=" + uid +
                ", name='" + name + '\'' +
                ", details='" + details + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", finished=" + finished +
                ", overdued=" + overdued +
                '}';
    }
}
