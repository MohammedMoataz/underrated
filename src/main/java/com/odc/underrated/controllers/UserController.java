package com.odc.underrated.controllers;

import com.odc.underrated.models.User;
import com.odc.underrated.repositories.UserRepository;
import com.odc.underrated.services.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository repo;

    @GetMapping
    public List<User> getUsers() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> getUser(@PathVariable(name = "id") Integer id) {
        return repo.findById(id);
    }
}
