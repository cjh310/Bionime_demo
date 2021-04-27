package com.example.demo.model.response;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.entity.User;

public class UserUpdateResponse {
    private Integer uid;
    private String name;
    private Integer staffId;

    private Integer status;
    private String message;

    public UserUpdateResponse() {
    }

    public UserUpdateResponse(UserEnum userEnum) {
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();
    }

    public UserUpdateResponse(User user, UserEnum userEnum) {
        this.uid = user.getUid();
        this.staffId = user.getStaffId();
        this.name = user.getName();
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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
