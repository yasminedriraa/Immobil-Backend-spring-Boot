package com.javainuse.service;

import com.javainuse.model.Category;

import java.util.List;

public interface CategoryService {
    Category createCategory (Category category);
    List<Category> getAllCategory();
    Category updateCAtegory(Long id, Category category);
    Category getCategoryByID(Long id);
    void deleteCategory(Long id);
}
