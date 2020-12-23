package com.sami.supershop.implementation;


import com.sami.supershop.domain.Category;
import com.sami.supershop.domain.Product;
import com.sami.supershop.dto.AddProductDto;
import com.sami.supershop.interfaces.ProductService;
import com.sami.supershop.repository.ProductRepository;
import com.sami.supershop.utility.DataStructureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return DataStructureUtils.toList(productRepository.findAll());
    }

    @Override
    public List<Product> getAllProductsByCategory(String category) {
        return productRepository.findAllByCategoryName(category);
    }

    @Override
    public Product getOneProduct(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public Product getOneProductByName(String name) {
        return productRepository.findByName(name);
    }

    @Override
    public void addProduct(AddProductDto productDto, Category category) {
        Product product = new Product ();
        product.setName(productDto.getCategoryName());
        product.setDescription(productDto.getDescription());
        product.setCost(productDto.getCost());
        product.setCategory(category);
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

}
