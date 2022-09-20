package com.odc.underrated.services;

import com.odc.underrated.models.User;
import com.odc.underrated.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public void batch() {

    }

    @Override
    public void deleteUser(long id) {

    }
}
