package com.example.demo.model.entity;

import com.example.demo.model.request.SiteInsertRequest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "site")
public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sid;

    private String name;
    private Date modifyTime;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "user_site", joinColumns = {@JoinColumn(name = "sid")}, inverseJoinColumns = {@JoinColumn(name = "uid")})
    private List<User> users;

    public Site() {
    }

    public Site(SiteInsertRequest siteInsertRequest) {
        this.setName(siteInsertRequest.getName());
        this.setModifyTime(new Date());
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

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Site{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", modifyTime=" + modifyTime +
                ", users=" + users +
                '}';
    }
}
