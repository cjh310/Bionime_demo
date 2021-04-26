package com.example.demo.service.Impl;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.entity.Site;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.repository.SiteRepository;
import com.example.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.example.demo.Enums.SiteEnum.INSERT_SUCCESS;
import static com.example.demo.Enums.SiteEnum.SITE_EXISTS;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    SiteRepository siteRepository;


    @Override
    public SiteInsertResponse addSite(SiteInsertRequest siteInsertRequest) {
        Site oldSite = siteRepository.findByName(siteInsertRequest.getName());
        if (oldSite == null) {
            Site site = new Site(siteInsertRequest);
            return new SiteInsertResponse(siteRepository.save(site),INSERT_SUCCESS);
        }
        return new SiteInsertResponse(SITE_EXISTS);
    }
}
