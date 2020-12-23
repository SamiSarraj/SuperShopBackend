package com.sami.supershop.controller;


import com.sami.supershop.domain.Category;
import com.sami.supershop.domain.Product;
import com.sami.supershop.dto.AddProductDto;
import com.sami.supershop.interfaces.CategoryService;
import com.sami.supershop.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;
    private final CategoryService categoryService;

    @Autowired
    public ProductController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    @GetMapping("/getAll/{category}")
    public ResponseEntity<Object> getAllProductsByCategory(@PathVariable String category) {
        return new ResponseEntity<>(productService.getAllProductsByCategory(category), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getAllProductsByCategory(@PathVariable Long id) {
        return new ResponseEntity<>(productService.getOneProduct(id), HttpStatus.OK);
    }
    @PostMapping("/addNew")
    public ResponseEntity addNewProduct(@RequestBody AddProductDto addProductDto) {
        Category category = categoryService.getOneCategoryByName(addProductDto.getCategoryName());
        if (category == null) return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No such Category");
        productService.addProduct(addProductDto,category);
        return new ResponseEntity(HttpStatus.OK);
    }
    @DeleteMapping("/delete/{name}")
    public ResponseEntity deleteProduct(@PathVariable String name) {
        Product product = productService.getOneProductByName(name);
        if (product == null) return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body("No such Product");
        productService.deleteProduct(product);
        return new ResponseEntity(HttpStatus.OK);
    }

//    @RequestMapping(value = "/products")
//    public ResponseEntity<Object> getProduct() {
//        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
//    }

}
