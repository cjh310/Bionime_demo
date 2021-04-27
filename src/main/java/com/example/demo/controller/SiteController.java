package com.example.demo.controller;

import com.example.demo.Enums.SiteEnum;
import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.SiteSelectAllResponse;
import com.example.demo.model.response.SiteSelectResponse;
import com.example.demo.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

import static com.example.demo.Enums.SiteEnum.INSERT_SUCCESS;

@Controller
public class SiteController {
    @Autowired
    SiteService siteService;

    @GetMapping("/addSite")
    public String addSite(Model model, SiteInsertRequest siteInsertRequest) {
        SiteInsertResponse response = siteService.addSite(siteInsertRequest);
        if (response.getStatus() != 0) {
            model.addAttribute("message", response.getMessage());
            return "index";
        }
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

    @GetMapping("/selectSite")
    public String selectSite(Model model, Integer id) {
        SiteSelectResponse response = siteService.selectSite(id);
        if (response.getStatus() != 0) {
            model.addAttribute("message", response.getMessage());
            return "site";
        }
        model.addAttribute("site", response);
        return "site";
    }

    @DeleteMapping("/delSite")
    public String delSite(Model model, Integer id) {
        SiteEnum response = siteService.delSite(id);
        model.addAttribute("message", response.getZH());
        return "site";
    }
}

