package com.example.demo.service;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.SiteSelectAllResponse;
import com.example.demo.model.response.SiteSelectResponse;

import java.util.List;

public interface SiteService {
    SiteInsertResponse addSite(SiteInsertRequest siteInsertRequest);
    List<SiteSelectAllResponse> selectAllSite();
    SiteSelectResponse selectSite(Integer id);
    SiteEnum delSite(Integer id);
}
