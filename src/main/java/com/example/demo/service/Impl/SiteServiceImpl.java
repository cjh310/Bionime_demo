package com.example.demo.service.Impl;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.entity.Site;
import com.example.demo.model.entity.User;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.SiteSelectAllResponse;
import com.example.demo.model.response.SiteSelectResponse;
import com.example.demo.repository.SiteRepository;
import com.example.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
            return new SiteInsertResponse(siteRepository.save(site), INSERT_SUCCESS);
        }
        return new SiteInsertResponse(SITE_EXISTS);
    }

    @Override
    public List<SiteSelectAllResponse> selectAllSite() {
        List<Site> allSites = siteRepository.findAll();
        if (allSites != null) {
            List<SiteSelectAllResponse> allSitesResponse = new ArrayList<>();
            allSites.forEach(site ->
                    allSitesResponse.add(new SiteSelectAllResponse(site))
            );
            return allSitesResponse;
        }

        return null;
    }

    @Override
    public SiteSelectResponse selectSite(Integer id) {
        Optional<Site> site = siteRepository.findById(id);
        if (site.isPresent()) {
            Map<Integer, Date> userInfo = new HashMap<>();
            List<User> users = site.get().getUsers();
            users.forEach(user ->
                    userInfo.put(user.getStaffId(), user.getModifyTime())
            );
            return new SiteSelectResponse(site.get(),userInfo, SiteEnum.SUCCESS);
        }
        return new SiteSelectResponse(SiteEnum.SITE_NOT_EXISTS);
    }

    @Override
    public SiteEnum delSite(Integer id) {
        if(siteRepository.existsById(id)){
            siteRepository.deleteById(id);
            return SiteEnum.DEL_SUCCESS;
        }
        return SiteEnum.DEL_FAIL;
    }


}
