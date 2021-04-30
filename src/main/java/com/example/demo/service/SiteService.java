package com.example.demo.service;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.request.SiteUpdateRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.SiteSelectAllResponse;
import com.example.demo.model.response.SiteSelectResponse;
import com.example.demo.model.response.SiteUpdateResponse;

import java.util.List;

public interface SiteService {
    SiteInsertResponse addSite(SiteInsertRequest siteInsertRequest);

    List<SiteSelectAllResponse> selectAllSite();

    SiteSelectResponse selectSite(Integer id);

    SiteEnum delSite(Integer id);

    SiteUpdateResponse updateSite(SiteUpdateRequest siteUpdateRequest);
}
