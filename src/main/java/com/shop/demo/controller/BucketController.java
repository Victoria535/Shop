package com.shop.demo.controller;

import com.shop.demo.dto.ProductDTO;
import com.shop.demo.dto.UserDTO;
import com.shop.demo.entity.Bucket;
import com.shop.demo.entity.User;
import com.shop.demo.repository.BucketRepository;
import com.shop.demo.repository.ProductRepository;
import com.shop.demo.service.ProductService;
import com.shop.demo.service.UserServiceConv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class BucketController {

    @Autowired
    private UserServiceConv userService;
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
        Bucket oldBucket = bucketRepository.findByName(productDTO.getName());

        if (user != null && oldBucket==null) {
            Bucket bucket = new Bucket();
            bucket.setName(productDTO.getName());
            bucket.setCost(productDTO.getCost());
            bucket.setCount(1);
            bucket.setDescription(productDTO.getDescription());
            bucket.setPath(productDTO.getPath());
            bucket.setUser(user);
            return bucketRepository.save(bucket);
        } else if(user!=null && oldBucket!=null){
            Integer count = oldBucket.getCount();
            oldBucket.setCount(count+1);
            return bucketRepository.save(oldBucket);
        } else {
            return HttpStatus.NON_AUTHORITATIVE_INFORMATION;
        }
    }

    @PutMapping("/buyProducts")
    public UserDTO buyProducts(@AuthenticationPrincipal User user){
        List<Bucket> bucketList = bucketRepository.findByUser(user);
        Integer sum = bucketList.stream().mapToInt(count-> Integer.parseInt(count.getCost())*count.getCount()).sum();
        Integer before = user.getAccount();
        user.setAccount(before-sum);
        /*for (Bucket bucket : bucketList){
            bucketRepository.delete(bucket);
        }*/
        bucketList.forEach(bucket -> bucketRepository.delete(bucket));
        return userService.saveUser(user);
    }

    @GetMapping("/bucket/findAll")
    public List<Bucket> findBucket(@AuthenticationPrincipal User user){
        return bucketRepository.findByUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteProductFromBucket(@PathVariable Long id, @AuthenticationPrincipal User user) {
        Bucket bucket = bucketRepository.findByUserAndId(user,id);
        bucketRepository.delete(bucket);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/increment/{id}")
    public Bucket increment(@PathVariable Long id, @AuthenticationPrincipal User user){
        Bucket bucket = bucketRepository.findByUserAndId(user,id);
        Integer countBefore = bucket.getCount();
        bucket.setCount(countBefore+1);
        return bucketRepository.save(bucket);
    }

    @PutMapping("/decrement/{id}")
    public Bucket decrement(@PathVariable Long id, @AuthenticationPrincipal User user){
        Bucket bucket = bucketRepository.findByUserAndId(user,id);
        Integer countBefore = bucket.getCount();
        if (countBefore>1) {
            bucket.setCount(countBefore - 1);
        }
        return bucketRepository.save(bucket);
    }

}
