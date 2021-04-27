package com.example.demo.service;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.request.UserUpdateRequest;
import com.example.demo.model.response.UserInsertResponse;
import com.example.demo.model.response.UserSelectAllResponse;
import com.example.demo.model.response.UserSelectResponse;
import com.example.demo.model.response.UserUpdateResponse;

import java.util.List;

public interface UserService {
    UserInsertResponse addUser(UserInsertRequest userInsertRequest);

    List<UserSelectAllResponse> selectAllUser();

    UserSelectResponse selectUser(Integer id);

    UserEnum delUser(Integer id);

    UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest);
}
