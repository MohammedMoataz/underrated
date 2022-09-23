package com.odc.underrated.services;

import com.odc.underrated.dtos.req.UserReq;
import com.odc.underrated.dtos.res.UserRes;
import com.odc.underrated.models.User;
import com.odc.underrated.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    private static final String REGEX_PATTERN = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

    @Override
    public UserRes save(UserReq userReq) {
        User user = mapEntityFromRequest(userReq);

        if (user != null) {
            user = userRepository.save(user);
            return mapEntityToResponse(user);
        }

        return null;
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
        return patternMatches(userReq.getEmail())
                ? new User(
                userReq.getName(),
                userReq.getEmail(),
                userReq.getPassword(),
                userReq.getCountry()
        )
                : null;
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

    private static boolean patternMatches(String emailAddress) {
        return Pattern.compile(REGEX_PATTERN)
                .matcher(emailAddress)
                .matches();
    }
}
