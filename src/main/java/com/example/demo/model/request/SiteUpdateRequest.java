package com.example.demo.model.request;


import java.util.List;

public class SiteUpdateRequest {
    private Integer sid;
    private String name;
    List<Integer> sitesId;

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

    public List<Integer> getSitesId() {
        return sitesId;
    }

    public void setSitesId(List<Integer> sitesId) {
        this.sitesId = sitesId;
    }

    @Override
    public String toString() {
        return "SiteUpdateRequest{" +
                "sid=" + sid +
                ", name='" + name + '\'' +
                ", sitesId=" + sitesId +
                '}';
    }
}
