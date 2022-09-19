package com.odc.underrated.services;

import com.odc.underrated.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();

}
