package com.shop.demo.service;

import com.shop.demo.dto.ProductDTO;
import com.shop.demo.entity.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductConverter {
    public Product fromProductDTOToProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setId(productDTO.getId());
        product.setName(productDTO.getName());
        product.setCost(productDTO.getCost());
        product.setDescription(productDTO.getDescription());
        product.setPath(productDTO.getPath());
        product.setComposition(productDTO.getComposition());
        product.setCalories(productDTO.getCalories());
        return product;
    }

    public ProductDTO fromProductToProductDTO(Product product) {
        return ProductDTO.builder()
                .id(product.getId())
                .name(product.getName())
                .cost(product.getCost())
                .description(product.getDescription())
                .path(product.getPath())
                .calories(product.getCalories())
                .composition(product.getComposition())
                .build();
    }
}
