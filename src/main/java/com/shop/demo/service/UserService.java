package com.shop.demo.service;

import com.shop.demo.entity.User;
import com.shop.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User userFindByUsername = userRepository.findByUsername(s);

        if(userFindByUsername != null)
        {
            return userFindByUsername;
        }

        return null;
    }
}
