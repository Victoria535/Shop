package com.shop.demo.service;

import com.shop.demo.dto.ProductDTO;
import com.shop.demo.entity.Product;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    List<ProductDTO> findByNameLike(String name);
}
