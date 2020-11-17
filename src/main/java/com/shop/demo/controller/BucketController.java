package com.shop.demo.controller;

import com.shop.demo.entity.Bucket;
import com.shop.demo.entity.Product;
import com.shop.demo.entity.User;
import com.shop.demo.repository.BucketRepository;
import com.shop.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BucketController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BucketRepository bucketRepository;

    @GetMapping("/product/{id}")
    public Bucket getOne(@PathVariable Integer id, @AuthenticationPrincipal User user){
        Bucket bucket = new Bucket();
        Product product = productRepository.getOne(id);
        bucket.setId(product.getId());
        bucket.setName(product.getName());
        bucket.setCost(product.getCost());
        bucket.setDescription(product.getDescription());
        bucket.setPath(product.getPath());
        bucket.setUser(user);
        return bucketRepository.save(bucket);
    }
}
