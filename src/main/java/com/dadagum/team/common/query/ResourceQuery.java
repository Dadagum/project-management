package com.dadagum.team.common.query;

public class ResourceQuery {

    private Integer pid;

    private Integer rid;

    private String name;

    private String quantity;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getQuantity() { return quantity; }

    public void setQuantity(String quantity) { this.quantity = quantity; }

    public Integer getRid() { return rid; }

    public void setRid(Integer rid) { this.rid = rid; }
}
