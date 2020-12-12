package com.shop.demo.service;

import com.shop.demo.dto.ProductDTO;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll();
    List<ProductDTO> findByNameLike(String name);
    ProductDTO getProduct(Long id);
    List<ProductDTO> getProductsByType(String type);
}
