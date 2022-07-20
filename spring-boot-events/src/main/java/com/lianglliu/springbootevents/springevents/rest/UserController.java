package com.lianglliu.springbootevents.springevents.rest;

import com.lianglliu.springbootevents.springevents.domain.User;
import com.lianglliu.springbootevents.springevents.rest.request.UserRequest;
import com.lianglliu.springbootevents.springevents.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public User create(@Valid @RequestBody UserRequest request) {
        return userService.create(request);
    }
}
