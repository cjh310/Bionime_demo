package com.example.demo.model.response;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.entity.User;

public class UserInsertResponse {
    private String name;
    private Integer status;
    private String message;

    public UserInsertResponse() {
    }

    public UserInsertResponse(UserEnum userEnum) {
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();
    }

    public UserInsertResponse(User user, UserEnum userEnum) {
        this.name = user.getName();
        this.status = userEnum.getSTATUS();
        this.message = userEnum.getZH();
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
