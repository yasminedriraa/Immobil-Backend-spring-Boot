package com.javainuse.service.impl;

import com.javainuse.model.Category;
import com.javainuse.repository.CategoryRepository;
import com.javainuse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category updateCAtegory(Long id, Category category) {
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setId(category.getId());
        categoryToUpdate.setName(category.getName());
        categoryToUpdate.setAnnonces(category.getAnnonces());
        return categoryRepository.save(categoryToUpdate);
    }

    @Override
    public Category getCategoryByID(Long id) {
        return categoryRepository.findById(id).get();
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
