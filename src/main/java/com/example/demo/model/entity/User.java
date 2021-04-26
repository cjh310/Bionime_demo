package com.example.demo.model.entity;

import com.example.demo.model.request.UserInsertRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    private Integer staffId;
    private String name;
    private Date modifyTime;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_site", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "sid")})
    private List<Site> sites;

    public User() {
    }


    public User(UserInsertRequest userInsertRequest) {
        this.setName(userInsertRequest.getName());
//        this.setSites(userInsertRequest.getSites());
        this.setStaffId(userInsertRequest.getStaffId());
        this.setModifyTime(new Date());
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }
}