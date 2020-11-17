package com.shop.demo.repository;

import com.shop.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
    User findByAccountNumber(Integer number);
}
