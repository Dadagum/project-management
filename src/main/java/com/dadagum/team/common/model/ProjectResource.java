package com.dadagum.team.common.model;

import java.util.Date;

public class ProjectResource {

    private Integer id;

    private Integer pid;

    private String name;

    private Integer quantity;

    private Date createTime;

    public Date getCreateTime() { return createTime; }

    public void setCreateTime(Date createTime) { this.createTime = createTime; }

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

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


}
