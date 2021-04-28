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

    private String staffId;
    private String name;
    private Date modifyTime;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_site", joinColumns = {@JoinColumn(name = "uid")}, inverseJoinColumns = {@JoinColumn(name = "sid")})
    private List<Site> sites;

    public User() {
    }


    public User(UserInsertRequest userInsertRequest,List<Site> sites) {
        this.setStaffId(userInsertRequest.getStaffId());
        this.setName(userInsertRequest.getName());
        this.setModifyTime(new Date());

        this.setSites(sites);
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

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", staffId=" + staffId +
                ", name='" + name + '\'' +
                ", modifyTime=" + modifyTime +
                ", sites=" + sites +
                '}';
    }
}