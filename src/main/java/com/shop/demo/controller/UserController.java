package com.shop.demo.controller;

import com.shop.demo.dto.UserDTO;
import com.shop.demo.entity.User;
import com.shop.demo.service.UserServiceConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserServiceConv service;

    @GetMapping("/inset")
    public UserDTO inset(@AuthenticationPrincipal User user){
        return service.findUser(user);
    }

    @GetMapping("/username")
    public String getUser(@AuthenticationPrincipal User user){
        return user.getUsername();
    }
}
