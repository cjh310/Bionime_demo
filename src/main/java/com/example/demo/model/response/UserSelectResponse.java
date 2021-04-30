package com.example.demo.model.response;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.entity.User;

import java.util.List;
import java.util.Map;

public class UserSelectResponse {
    private Integer uid;
    private String staffId;
    private String name;

    private List<Map<String, Object>> siteInfo;
    private List<Map<String, Object>> allSitesInfo;

    private Integer status;
    private String message;

    public UserSelectResponse() {
    }

    public UserSelectResponse(UserEnum userEnum) {
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();

    }

    public UserSelectResponse(User user, List<Map<String, Object>> siteInfo, List<Map<String, Object>> allSitesInfo, UserEnum userEnum) {
        this.uid = user.getUid();
        this.staffId = user.getStaffId();
        this.name = user.getName();
        this.siteInfo = siteInfo;
        this.allSitesInfo = allSitesInfo;
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

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

    public List<Map<String, Object>> getSiteInfo() {
        return siteInfo;
    }

    public void setSiteInfo(List<Map<String, Object>> siteInfo) {
        this.siteInfo = siteInfo;
    }

    public List<Map<String, Object>> getAllSitesInfo() {
        return allSitesInfo;
    }

    public void setAllSitesInfo(List<Map<String, Object>> allSitesInfo) {
        this.allSitesInfo = allSitesInfo;
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
        return "UserSelectResponse{" +
                "uid=" + uid +
                ", staffId='" + staffId + '\'' +
                ", name='" + name + '\'' +
                ", siteInfo=" + siteInfo +
                ", allSitesInfo=" + allSitesInfo +
                ", status=" + status +
                ", message='" + message + '\'' +
                '}';
    }
}
