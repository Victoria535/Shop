package com.shop.demo.repository;

import com.shop.demo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select p from Product p where p.name like %:name%")
    List<Product> findByNameLike(@Param("name")String name);
    List<Product> findByType(String type);
}
