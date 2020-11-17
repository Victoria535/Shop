package com.shop.demo.service;


import com.shop.demo.dto.UserDTO;
import com.shop.demo.entity.User;

public interface UserServiceConv {
    UserDTO findUser(User user);
}
