package com.shop.demo.controller;

import com.shop.demo.dto.ProductDTO;
import com.shop.demo.entity.Bucket;
import com.shop.demo.entity.User;
import com.shop.demo.repository.BucketRepository;
import com.shop.demo.repository.ProductRepository;
import com.shop.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BucketController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private BucketRepository bucketRepository;
    @Autowired
    private ProductService productService;

    //    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/product/{id}")
    public ProductDTO getOne(@PathVariable Long id) {
        return productService.getProduct(id);
    }

    //    @PreAuthorize("hasAuthority('USER')")
    @PostMapping("/createBucket")
    public Object createBucket(@RequestBody ProductDTO productDTO, @AuthenticationPrincipal User user) {
        if (user != null) {
            Bucket bucket = new Bucket();
            bucket.setName(productDTO.getName());
            bucket.setCost(productDTO.getCost());
            bucket.setCount(1);
            bucket.setDescription(productDTO.getDescription());
            bucket.setPath(productDTO.getPath());
            bucket.setUser(user);
            return bucketRepository.save(bucket);
        } else {
            return HttpStatus.NON_AUTHORITATIVE_INFORMATION;
        }
    }
}
