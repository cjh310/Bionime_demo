package com.example.demo.controller;

import com.example.demo.Enums.UserEnum;
import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.request.UserUpdateRequest;
import com.example.demo.model.response.UserInsertResponse;
import com.example.demo.model.response.UserSelectAllResponse;
import com.example.demo.model.response.UserSelectResponse;
import com.example.demo.model.response.UserUpdateResponse;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import static com.example.demo.Enums.UserEnum.INSERT_SUCCESS;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/addUser")
    public String index(Model model, UserInsertRequest userInsertRequest) {
        if(userInsertRequest.getStaffId()==null||userInsertRequest.getStaffId().isEmpty()){
            this.selectAllUsers(model);
            model.addAttribute("status", UserEnum.NOT_NULL.getSTATUS());
            model.addAttribute("message", "員工編號"+UserEnum.NOT_NULL.getZH());
            return "index";
        }
        UserInsertResponse response = userService.addUser(userInsertRequest);
        if (response.getStatus() != 0) {
            model.addAttribute("status", response.getStatus());
            model.addAttribute("message", response.getMessage());
            return "index";
        }
        model.addAttribute("status", response.getStatus());
        model.addAttribute("message", response.getName() + INSERT_SUCCESS.getZH());
        return "index";
    }


    @GetMapping("/selectAllUsers")
    public String selectAllUsers(Model model) {
        List<UserSelectAllResponse> response = userService.selectAllUser();
        if (response == null) {
            model.addAttribute("message", UserEnum.USER_NOT_EXISTS.getZH());
            return "user";
        }
        model.addAttribute("allUsers", response);
        return "user";
    }

    @GetMapping("/selectUser")
    @ResponseBody
    public UserSelectResponse selectUser(Model model, Integer uid) {
        if (uid != null) {
            return userService.selectUser(uid);
        }
        return null;
    }

    @GetMapping("/delUser")
    public String delUser(Model model, Integer uid) {
        UserEnum response = userService.delUser(uid);
        this.selectAllUsers(model);
        model.addAttribute("status", response.getSTATUS());
        model.addAttribute("message", response.getZH());
        return "user";
    }


    @GetMapping("/updateUser")
    public String updateUser(Model model, UserUpdateRequest userUpdateRequest) {
        if(userUpdateRequest.getStaffId()==null||userUpdateRequest.getStaffId().isEmpty()){
            this.selectAllUsers(model);
            model.addAttribute("status", UserEnum.NOT_NULL.getSTATUS());
            model.addAttribute("message", "員工編號"+UserEnum.NOT_NULL.getZH());
            return "user";
        }
        UserUpdateResponse response = userService.updateUser(userUpdateRequest);
        if (response.getStatus() != 0) {
            model.addAttribute("user", userUpdateRequest);
            model.addAttribute("status", response.getStatus());
            model.addAttribute("message", response.getMessage());
            return "user";
        }
        this.selectAllUsers(model);
        model.addAttribute("status", response.getStatus());
        model.addAttribute("message", response.getMessage());
        return "user";
    }
}

