package com.example.demo.service.Impl;


import com.example.demo.Enums.UserEnum;
import com.example.demo.model.entity.Site;
import com.example.demo.model.entity.User;
import com.example.demo.model.request.UserInsertRequest;
import com.example.demo.model.request.UserUpdateRequest;
import com.example.demo.model.response.UserInsertResponse;
import com.example.demo.model.response.UserSelectAllResponse;
import com.example.demo.model.response.UserSelectResponse;
import com.example.demo.model.response.UserUpdateResponse;
import com.example.demo.repository.SiteRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SiteRepository siteRepository;


    @Override
    public UserInsertResponse addUser(UserInsertRequest userInsertRequest) {
        User oldUser = userRepository.findByStaffId(userInsertRequest.getStaffId());
        if (oldUser == null) {
            List<Site> sites;
            try {
                Iterable<Integer> iterable = userInsertRequest.getSitesId();
                sites = siteRepository.findAllById(iterable);
            } catch (Exception e) {
                e.printStackTrace();
                return new UserInsertResponse(UserEnum.ERROR);
            }
            User user = new User(userInsertRequest, sites);
            User save = userRepository.save(user);
            return new UserInsertResponse(save, UserEnum.INSERT_SUCCESS);
        }
        return new UserInsertResponse(UserEnum.USER_EXISTS);
    }

    @Override
    public List<UserSelectAllResponse> selectAllUser() {
        List<User> allUsers = userRepository.findAll();
        if (allUsers != null) {
            List<UserSelectAllResponse> allUserResponse = new ArrayList<>();
            allUsers.forEach(user ->
                    allUserResponse.add(new UserSelectAllResponse(user))
            );
            return allUserResponse;
        }

        return null;
    }

    @Override
    public UserSelectResponse selectUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            List<String> siteInfo = new ArrayList<>();
            List<Site> sites = user.get().getSites();
            sites.forEach(site ->
                    siteInfo.add(user.get().getName())
            );
            return new UserSelectResponse(user.get(), siteInfo, UserEnum.SUCCESS);
        }
        return new UserSelectResponse(UserEnum.USER_NOT_EXISTS);
    }

    @Override
    public UserEnum delUser(Integer id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return UserEnum.DEL_SUCCESS;
        }
        return UserEnum.DEL_FAIL;
    }

    @Override
    public UserUpdateResponse updateUser(UserUpdateRequest userUpdateRequest) {
        Optional<User> byId = userRepository.findById(userUpdateRequest.getUid());
        if (byId.isPresent()) {
            User user = byId.get();
            user.setStaffId(userUpdateRequest.getStaffId());
            user.setName(userUpdateRequest.getName());
            user.setModifyTime(new Date());
            user.setSites(userUpdateRequest.getSites());
            userRepository.save(user);
            return new UserUpdateResponse(user, UserEnum.MODIFY_SUCCESS);
        }
        return new UserUpdateResponse(UserEnum.MODIFY_FAIL);
    }
}

