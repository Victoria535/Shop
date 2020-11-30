package com.shop.demo.repository;

import com.shop.demo.entity.Bucket;
import com.shop.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BucketRepository extends JpaRepository<Bucket, Long> {
    List<Bucket> findByUser(User user);
    Bucket findByName(String name);
}
