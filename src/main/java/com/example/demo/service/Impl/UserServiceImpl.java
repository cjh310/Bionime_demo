package com.example.demo.service.Impl;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.entity.User;
import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.response.UserInsertResponse;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserInsertResponse addUser(UserInsertRequest userInsertRequest) {
        User oldUser = userRepository.findByStaffId(userInsertRequest.getStaffId());
        if (oldUser == null) {
            User user = new User(userInsertRequest);
            User save = userRepository.save(user);
            return new UserInsertResponse(save, UserEnum.INSERT_SUCCESS);
        }
        return new UserInsertResponse(UserEnum.USER_EXISTS);
    }
}
