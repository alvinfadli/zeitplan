package com.personal.zeitplan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.personal.zeitplan.entity.User;
import com.personal.zeitplan.model.RegisterUserRequest;
import com.personal.zeitplan.model.UserResponse;
import com.personal.zeitplan.model.WebResponse;
import com.personal.zeitplan.service.UserService;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(
        path = "/api/users", 
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<String> register(@RequestBody RegisterUserRequest request){
        userService.register(request);

        return WebResponse.<String>builder().data("OK").build();
    }

    @GetMapping(
        path = "/api/users/current",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public WebResponse<UserResponse> get(User user){
        UserResponse userResponse = userService.get(user);
        return WebResponse.<UserResponse>builder().data(userResponse).build();
    }
}
