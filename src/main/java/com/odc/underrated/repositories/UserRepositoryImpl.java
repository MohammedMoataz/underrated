package com.odc.underrated.repositories;

import com.odc.underrated.models.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {

    @Override
    public User createUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(long id) {

    }
}
