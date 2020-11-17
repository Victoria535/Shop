package com.shop.demo.repository;

import com.shop.demo.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {
    @Autowired
    ProductRepository repository;

    @Test
    public void findByNameLikeTest(){
        String name = "сах";
        List<Product> product = repository.findByNameLike(name);
        product.forEach(System.out::println);
    }

}