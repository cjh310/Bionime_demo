package com.example.demo.model.response;


import com.example.demo.model.entity.Site;

import java.util.Date;

public class SiteSelectAllResponse {
    private Integer sid;
    private String name;
    private Date modifyTime;


    public SiteSelectAllResponse() {
    }


    public SiteSelectAllResponse(Site site) {
        this.sid = site.getSid();
        this.name = site.getName();
        this.modifyTime = site.getModifyTime();
    }


    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    @Override
    public String toString() {
        return "SiteSelectAllResponse{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", modifyTime=" + modifyTime +
                '}';
    }
}
