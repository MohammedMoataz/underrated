package com.odc.underrated.controllers;

import com.odc.underrated.dtos.req.UserReq;
import com.odc.underrated.dtos.res.UserRes;
import com.odc.underrated.services.UserService;
import com.odc.underrated.util.ServiceError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody UserRes save(@RequestBody UserReq userReq) {
        return userService.save(userReq);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List<UserRes> findAll() {
        return userService.findAll();
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public @ResponseBody UserRes findById(@PathVariable(value = "id") String id) {
        return userService.findById(id);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public @ResponseBody UserRes updateUser(@PathVariable(value = "id") String id, @RequestBody UserReq userReq) {
        return userService.updateUser(id, userReq);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Object delete(@PathVariable(value = "id") String id) {
        userService.deleteById(id);
        return null;
    }

    @RequestMapping(value = "/user/test", method = RequestMethod.GET)
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
