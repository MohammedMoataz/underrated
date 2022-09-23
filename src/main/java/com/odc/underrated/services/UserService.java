package com.odc.underrated.services;

import com.odc.underrated.dtos.req.UserReq;
import com.odc.underrated.dtos.res.UserRes;

import java.util.List;

public interface UserService {

    UserRes save(UserReq userReq);

    UserRes findById(String id);

    List<UserRes> findAll();

    UserRes updateUser(String userId, UserReq userReq);

    void deleteById(String id);

}
