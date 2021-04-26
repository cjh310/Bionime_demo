package com.example.demo.controller;

import com.example.demo.model.request.SiteInsertRequest;
import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.response.SiteInsertResponse;
import com.example.demo.model.response.UserInsertResponse;
import com.example.demo.service.SiteService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import static com.example.demo.Enums.SiteEnum.INSERT_SUCCESS;

@Controller
public class SiteController {
    @Autowired
    SiteService siteService;

    @GetMapping("/addSite")
    public String index(Model model, SiteInsertRequest siteInsertRequest) {
        SiteInsertResponse response=siteService.addSite(siteInsertRequest);
        if(response.getStatus()!=0){
            model.addAttribute("message",response.getMessage());
            return "index";
        }
        model.addAttribute("message",response.getName()+INSERT_SUCCESS.getZH());
        return "index";
    }
}

