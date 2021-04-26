package com.example.demo.model.response;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.entity.Site;

public class SiteInsertResponse {
    private String name;
    private Integer status;
    private String message;

    public SiteInsertResponse() {
    }
    public SiteInsertResponse(SiteEnum siteEnum) {
        this.status = siteEnum.getSTATUS();
        this.message = siteEnum.getZH();
    }
    public SiteInsertResponse(Site site, SiteEnum siteEnum) {
        this.name = site.getName();
        this.status = siteEnum.getSTATUS();
        this.message = siteEnum.getZH();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
