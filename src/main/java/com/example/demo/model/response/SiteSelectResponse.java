package com.example.demo.model.response;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.entity.Site;
import com.example.demo.model.entity.User;

import java.util.Date;
import java.util.Map;

public class SiteSelectResponse {
    private String name;

    private Map<Integer,Date> userInfo;

    private Integer status;
    private String message;

    public SiteSelectResponse() {
    }
    public SiteSelectResponse(SiteEnum siteEnum){
        this.status=siteEnum.getSTATUS();
        this.message=siteEnum.getZH();

    }
    public SiteSelectResponse(Site site, Map<Integer,Date> userInfo,SiteEnum siteEnum) {
        this.name = site.getName();
        this.userInfo = userInfo;

        this.status=siteEnum.getSTATUS();
        this.message=siteEnum.getZH();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, Date> getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(Map<Integer, Date> userInfo) {
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
}
