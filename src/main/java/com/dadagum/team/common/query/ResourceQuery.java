package com.dadagum.team.common.query;

public class ResourceQuery {

    private Integer pid;

    private Integer rid;

    private String name;

    private Integer quantity;

    private String details;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Integer getQuantity() { return quantity; }

    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public Integer getRid() { return rid; }

    public void setRid(Integer rid) { this.rid = rid; }

    public String getDetails() { return details; }

    public void setDetails(String details) { this.details = details; }
}
