package com.example.demo.service.Impl;


import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.entity.Site;
import com.example.demo.model.entity.User;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.request.SiteUpdateRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.SiteSelectAllResponse;
import com.example.demo.model.response.SiteSelectResponse;
import com.example.demo.model.response.SiteUpdateResponse;
import com.example.demo.repository.SiteRepository;
import com.example.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
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
            List<Map<String, Object>> userInfo = new ArrayList<>();
            List<User> users = site.get().getUsers();
            users.forEach(user -> {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

                        Map<String, Object> userVo = new HashMap<>();
                        userVo.put("staffId", user.getStaffId());
                        userVo.put("modifyTime", sdf.format(user.getModifyTime()));
                        userInfo.add(userVo);
                    }

            );
            return new SiteSelectResponse(site.get(), userInfo, SiteEnum.SUCCESS);
        }
        return new SiteSelectResponse(SiteEnum.SITE_NOT_EXISTS);
    }

    @Override
    public SiteEnum delSite(Integer id) {
        if (siteRepository.existsById(id)) {
            siteRepository.deleteById(id);
            return SiteEnum.DEL_SUCCESS;
        }
        return SiteEnum.DEL_FAIL;
    }

    @Override
    public SiteUpdateResponse updateSite(SiteUpdateRequest siteUpdateRequest) {
        Optional<Site> byId = siteRepository.findById(siteUpdateRequest.getSid());
        if (byId.isPresent()) {
            Site site = byId.get();
            site.setName(siteUpdateRequest.getName());
            site.setModifyTime(new Date());
            siteRepository.save(site);
            return new SiteUpdateResponse(site, SiteEnum.MODIFY_SUCCESS);
        }
        return new SiteUpdateResponse(SiteEnum.MODIFY_FAIL);
    }
}
