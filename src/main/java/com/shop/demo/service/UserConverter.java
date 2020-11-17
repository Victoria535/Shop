package com.shop.demo.service;


import com.shop.demo.dto.UserDTO;
import com.shop.demo.entity.User;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public User fromUserDTOToUser(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setUsername(userDTO.getUsername());
        user.setAccountNumber(userDTO.getAccountNumber());
        user.setAccount(userDTO.getAccount());
        return user;
    }

    public UserDTO fromUserToUserDTO(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .username(user.getUsername())
                .accountNumber(user.getAccountNumber())
                .account(user.getAccount())
                .build();
    }
}
