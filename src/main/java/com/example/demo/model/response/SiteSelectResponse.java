package com.example.demo.model.response;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.entity.Site;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class SiteSelectResponse {
    private Integer sid;
    private String name;

    private List<Map<String,Object>> userInfo;

    private Integer status;
    private String message;

    public SiteSelectResponse() {
    }

    public SiteSelectResponse(SiteEnum siteEnum) {
        this.status = siteEnum.getSTATUS();
        this.message = siteEnum.getZH();

    }

    public SiteSelectResponse(Site site, List<Map<String,Object>> userInfo, SiteEnum siteEnum) {
        this.sid = site.getSid();
        this.name = site.getName();
        this.userInfo = userInfo;

        this.status = siteEnum.getSTATUS();
        this.message = siteEnum.getZH();
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

    public List<Map<String,Object>> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(List<Map<String,Object>> userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "SiteSelectResponse{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", userInfo=" + userInfo +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
