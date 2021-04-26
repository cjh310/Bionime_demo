package com.example.demo.service;


import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.response.UserInsertResponse;

public interface UserService {
    UserInsertResponse addUser(UserInsertRequest userInsertRequest);
}
