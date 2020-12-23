package com.sami.supershop.interfaces;

import com.sami.supershop.domain.Category;
import com.sami.supershop.domain.Product;
import com.sami.supershop.dto.AddProductDto;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    List<Product> getAllProductsByCategory(String category);
    Product getOneProduct(Long id);
    Product getOneProductByName(String name);
    void addProduct(AddProductDto productDto, Category category);
    void deleteProduct(Product product);

}
