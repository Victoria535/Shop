package com.shop.demo.service;

import com.shop.demo.dto.ProductDTO;
import com.shop.demo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//@Slf4j
public class ProductServiceImpl implements ProductService {

    private final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream().map(productConverter::fromProductToProductDTO).collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByNameLike(String name) {

        return productRepository.findByNameLike(name)
                .stream().map(productConverter::fromProductToProductDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDTO getProduct(Long id) {
        ProductDTO product = productConverter.fromProductToProductDTO(productRepository.getOne(id));
        return product;
    }

}
