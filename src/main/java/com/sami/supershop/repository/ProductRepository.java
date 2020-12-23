package com.sami.supershop.repository;

import com.sami.supershop.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByCategoryName(String Category);
    Product findProductById(Long id);
    Product findByName(String name);
}
