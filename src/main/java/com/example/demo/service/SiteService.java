package com.example.demo.service;


import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.response.SiteInsertResponse;

public interface SiteService {
    SiteInsertResponse addSite(SiteInsertRequest siteInsertRequest);
}
