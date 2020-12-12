package com.shop.demo.controller;

import com.shop.demo.dto.ProductDTO;
import com.shop.demo.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
@Log
@CrossOrigin
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    public List<ProductDTO> findAllProduct(){
        log.info("Find all products");
        return productService.findAll();
    }

    @GetMapping("/search")
    public List<ProductDTO> findProduct(@RequestParam String name){
        if (name != null && !name.isEmpty()) {
            log.info("Find products by name " + name);
            return productService.findByNameLike(name);
        }
        log.info("Find all products");
        return productService.findAll();
    }

    @GetMapping("/getByType")
    public List<ProductDTO> findProductsByType(@RequestParam String type){
        return productService.getProductsByType(type);
    }

}
