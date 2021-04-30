package com.example.demo.model.request;


import java.util.Date;
import java.util.List;

public class UserInsertRequest {
    private String staffId;
    private String name;
    private Date modifyTime;
    List<Integer> sitesId;

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<Integer> getSitesId() {
        return sitesId;
    }

    public void setSitesId(List<Integer> sitesId) {
        this.sitesId = sitesId;
    }

    @Override
    public String toString() {
        return "UserInsertRequest{" +
                "staffId=" + staffId +
                ", name='" + name + '\'' +
                ", modifyTime=" + modifyTime +
                ", sitesId=" + sitesId +
                '}';
    }
}
