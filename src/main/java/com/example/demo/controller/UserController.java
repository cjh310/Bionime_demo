package com.example.demo.controller;

import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.response.UserInsertResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

import static com.example.demo.Enums.UserEnum.INSERT_SUCCESS;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public String index(Model model, UserInsertRequest userInsertRequest) {
        UserInsertResponse response=userService.addUser(userInsertRequest);
        if(response.getStatus()!=0){
            model.addAttribute("message",response.getMessage());
            return "index";
        }
        model.addAttribute("message",response.getName()+INSERT_SUCCESS.getZH());
        return "index";
    }
}

