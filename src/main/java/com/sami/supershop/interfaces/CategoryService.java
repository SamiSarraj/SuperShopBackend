package com.sami.supershop.interfaces;

import com.sami.supershop.domain.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getOneCategoryByName(String name);
    void addCategory(Category category);
    void deleteCategory(Category category);
    void modifyCategory(Category category);
}
