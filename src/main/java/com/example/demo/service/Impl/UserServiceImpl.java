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

import java.util.*;

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
        List<Site> allSites = siteRepository.findAll();
        if (user.isPresent()) {
            List<Map<String, Object>> siteInfo = new ArrayList<>();
            List<Map<String, Object>> allSitesInfo = new ArrayList<>();
            List<Site> sites = user.get().getSites();
            if (!sites.isEmpty()) {
                sites.forEach(site -> {
                    Map<String, Object> userSitesVo = new HashMap<>();
                    userSitesVo.put("sid", site.getSid());
                    userSitesVo.put("name", site.getName());
                    siteInfo.add(userSitesVo);
                });
            }
            if (allSites != null) {
                allSites.forEach(site -> {
                    Map<String, Object> allSitesVO = new HashMap<>();
                    allSitesVO.put("sid", site.getSid());
                    allSitesVO.put("name", site.getName());
                    allSitesInfo.add(allSitesVO);
                });
            }
            return new UserSelectResponse(user.get(), siteInfo, allSitesInfo, UserEnum.SUCCESS);
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
            List<Site> sites = null;
            if (userUpdateRequest.getSitesId() != null) {
                try {
                    Iterable<Integer> iterable = userUpdateRequest.getSitesId();
                    sites = siteRepository.findAllById(iterable);
                } catch (Exception e) {
                    e.printStackTrace();
                    return new UserUpdateResponse(UserEnum.ERROR);
                }
            }
            user.setSites(sites);
            userRepository.save(user);
            return new UserUpdateResponse(user, UserEnum.MODIFY_SUCCESS);
        }
        return new UserUpdateResponse(UserEnum.MODIFY_FAIL);
    }
}

