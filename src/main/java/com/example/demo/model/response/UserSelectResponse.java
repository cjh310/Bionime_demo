package com.example.demo.model.response;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.entity.User;

import java.util.List;

public class UserSelectResponse {
    private Integer uid;
    private Integer staffId;
    private String name;

    private List<String> siteInfo;

    private Integer status;
    private String message;

    public UserSelectResponse() {
    }

    public UserSelectResponse(UserEnum userEnum) {
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();

    }

    public UserSelectResponse(User user, List<String> siteInfo, UserEnum userEnum) {
        this.uid = user.getUid();
        this.staffId = user.getStaffId();
        this.name = user.getName();
        this.siteInfo = siteInfo;
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(List<String> siteInfo) {
        this.siteInfo = siteInfo;
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
