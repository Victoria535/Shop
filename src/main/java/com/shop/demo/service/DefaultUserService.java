package com.shop.demo.service;

import com.shop.demo.dto.UserDTO;
import com.shop.demo.entity.User;
import com.shop.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefaultUserService implements UserServiceConv{
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public UserDTO findUser(User user) {
        return userConverter.fromUserToUserDTO(userRepository.getOne(user.getId()));
    }

    @Override
    public UserDTO saveUser(User user) {
        return userConverter.fromUserToUserDTO(userRepository.save(user));
    }


}
