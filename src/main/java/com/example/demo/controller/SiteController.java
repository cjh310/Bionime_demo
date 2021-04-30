package com.example.demo.controller;

import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.request.SiteUpdateRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.SiteSelectAllResponse;
import com.example.demo.model.response.SiteSelectResponse;
import com.example.demo.model.response.SiteUpdateResponse;
import com.example.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.example.demo.Enums.SiteEnum.INSERT_SUCCESS;

@Controller
public class SiteController {
    @Autowired
    SiteService siteService;

    @GetMapping("/addSite")
    public String addSite(Model model, SiteInsertRequest siteInsertRequest) {
        if(siteInsertRequest.getName()==null||siteInsertRequest.getName().isEmpty()){
            this.selectAllSites(model);
            model.addAttribute("status", SiteEnum.NOT_NULL.getSTATUS());
            model.addAttribute("message", "站點名稱"+SiteEnum.NOT_NULL.getZH());
            return "index";
        }
        SiteInsertResponse response = siteService.addSite(siteInsertRequest);
        if (response.getStatus() != 0) {
            model.addAttribute("status", response.getStatus());
            model.addAttribute("message", response.getMessage());
            return "index";
        }
        model.addAttribute("siteName", siteInsertRequest.getName());
        model.addAttribute("status", response.getStatus());
        model.addAttribute("message", response.getName() + INSERT_SUCCESS.getZH());
        return "index";
    }

    @GetMapping("/selectAllSites")
    public String selectAllSites(Model model) {
        List<SiteSelectAllResponse> response = siteService.selectAllSite();
        if (response == null) {
            model.addAttribute("message", SiteEnum.SITE_NOT_EXISTS.getZH());
            return "site";
        }
        model.addAttribute("allSites", response);
        return "site";
    }

    @GetMapping("/selectAllSitesAjax")
    @ResponseBody
    public List<SiteSelectAllResponse> selectAllSitesAjax(Model model) {
        return siteService.selectAllSite();
    }

    @GetMapping("/selectSite")
    @ResponseBody
    public SiteSelectResponse selectSite(Model model, Integer sid) {
        if (sid != null) {
            return siteService.selectSite(sid);
        }
        return null;
    }

    @GetMapping("/delSite")
    public String delSite(Model model, Integer sid) {
        SiteEnum response = siteService.delSite(sid);

        model.addAttribute("status", response.getSTATUS());
        model.addAttribute("message", response.getZH());
        this.selectAllSites(model);
        return "site";
    }


    @GetMapping("/updateSite")
    public String updateSite(Model model, SiteUpdateRequest siteUpdateRequest) {
        if(siteUpdateRequest.getName()==null||siteUpdateRequest.getName().isEmpty()){
            this.selectAllSites(model);
            model.addAttribute("status", SiteEnum.NOT_NULL.getSTATUS());
            model.addAttribute("message", "站點名稱"+SiteEnum.NOT_NULL.getZH());
            return "site";
        }
        SiteUpdateResponse response = siteService.updateSite(siteUpdateRequest);
        if (response.getStatus() != 0) {
            model.addAttribute("site", siteUpdateRequest);
            model.addAttribute("status", response.getStatus());
            model.addAttribute("message", response.getMessage());
            return "site";
        }
        model.addAttribute("status", response.getStatus());
        model.addAttribute("message", response.getMessage());
        this.selectAllSites(model);
        return "site";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }
}

