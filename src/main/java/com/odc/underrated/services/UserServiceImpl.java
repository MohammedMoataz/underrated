package com.odc.underrated.services;

import com.odc.underrated.dtos.req.UserReq;
import com.odc.underrated.dtos.res.UserRes;
import com.odc.underrated.models.User;
import com.odc.underrated.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserRes save(UserReq userReq) {
        User user = mapEntityFromRequest(userReq);
        user = userRepository.save(user);
        return mapEntityToResponse(user);
    }

    @Override
    public UserRes findById(String id) {
        return mapEntityToResponse(userRepository.findById(id).get());
    }

    @Override
    public List<UserRes> findAll() {
        List<UserRes> response = new ArrayList<>();
        userRepository.findAll().forEach(user ->
                response.add(mapEntityToResponse(user))
        );

        return response;
    }

    @Override
    public UserRes updateUser(String userId, UserReq userReq) {
        User user = userRepository.findById(userId).get();
        updateEntityFromResponse(user, userReq);
        userRepository.save(user);
        return mapEntityToResponse(user);
    }

    @Override
    public void deleteById(String id) {
        userRepository.deleteById(id);
    }

    private User mapEntityFromRequest(UserReq userReq) {
        return new User(
                userReq.getName(),
                userReq.getEmail(),
                userReq.getPassword(),
                userReq.getCountry()
        );
    }

    private void updateEntityFromResponse(User user, UserReq userReq) {
        user.setName(userReq.getName());
        user.setEmail(userReq.getEmail());
        user.setPassword(userReq.getPassword());
        user.setCountry(userReq.getCountry());
    }

    private UserRes mapEntityToResponse(User user) {
        return new UserRes(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getCountry()
        );
    }
}
