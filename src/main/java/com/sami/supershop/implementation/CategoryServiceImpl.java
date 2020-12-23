package com.sami.supershop.implementation;

import com.sami.supershop.domain.Category;
import com.sami.supershop.interfaces.CategoryService;
import com.sami.supershop.repository.CategoryRepository;
import com.sami.supershop.utility.DataStructureUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        return DataStructureUtils.toList(categoryRepository.findAll());
    }

    @Override
    public Category getOneCategoryByName(String name) {
        return categoryRepository.findByName(name);
    }

    @Override
    public void addCategory(Category category) {
    categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Category category) {
    categoryRepository.delete(category);
    }

    @Override
    public void modifyCategory(Category category) {

    }
}
