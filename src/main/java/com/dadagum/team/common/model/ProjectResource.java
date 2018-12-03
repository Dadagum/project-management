package com.dadagum.team.common.model;



public class ProjectResource {

    private Integer id;

    private Integer pid;

    private Integer gid;

    private String name;

    private Integer quantity;

    private String createTime;

    public String getCreateTime() { return createTime; }

    public void setCreateTime(String createTime) { this.createTime = createTime; }

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
