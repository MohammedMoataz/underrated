package com.odc.underrated.services;

import com.odc.underrated.models.User;

import java.util.List;

public interface UserService {

    User createUser(User user);

    List<User> getUsers();

    void batch();

    void deleteUser(long id);

}
