package com.sami.supershop.controller;

import com.sami.supershop.domain.Category;
import com.sami.supershop.interfaces.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("/getAll")
    public ResponseEntity<Object> getAllCategories() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }
    @PostMapping("/addNew")
    public ResponseEntity addNewCategory(@RequestBody Category category) {
        categoryService.addCategory(category);
        return new ResponseEntity(HttpStatus.OK); //@responseStatus
    }
    @DeleteMapping("/delete/{name}")
    public ResponseEntity deleteCategory(@PathVariable String name) {
        Category category = categoryService.getOneCategoryByName(name);
        if (category == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);
        categoryService.deleteCategory(category);
        return new ResponseEntity(HttpStatus.OK);
    }
}
