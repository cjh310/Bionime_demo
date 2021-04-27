package com.example.demo.model.response;


import com.example.demo.model.entity.User;

import java.util.Date;

public class UserSelectAllResponse {
    private Integer uid;
    private Integer staffId;
    private Date modifyTime;


    public UserSelectAllResponse() {
    }


    public UserSelectAllResponse(User user) {
        this.modifyTime = user.getModifyTime();
        this.staffId = user.getStaffId();
        this.uid = user.getUid();
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
