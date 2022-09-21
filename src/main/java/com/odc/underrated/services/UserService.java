package com.odc.underrated.services;

import com.odc.underrated.models.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUser(Long id);

    List<User> getUsers();

    User updateUser(User user);

    void deleteUser(Long id);

}
