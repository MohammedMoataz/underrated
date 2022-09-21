package com.odc.underrated.controllers;


import com.odc.underrated.models.User;
import com.odc.underrated.services.UserService;
import com.odc.underrated.util.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/u")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody User getUser(@PathVariable(value = "id") Long id) {
        return userService.getUser(id);
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public @ResponseBody User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value = "id") Long id) {
        userService.deleteUser(id);
        return null;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public @ResponseBody Object test() {
        throw new DataAccessException("Testing exception thrown") {
        };
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ServiceError> handle(RuntimeException ex) {
        ServiceError error = new ServiceError(HttpStatus.OK.value(), ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.OK);
    }
}
