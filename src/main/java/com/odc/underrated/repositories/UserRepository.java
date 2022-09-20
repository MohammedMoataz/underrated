package com.odc.underrated.repositories;

import com.odc.underrated.models.User;

import java.util.List;

public interface UserRepository {

    User createUser(User user);

    List<User> getUsers();

    User updateUser(User user);

    void deleteUser(long id);
}
