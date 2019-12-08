package com.javainuse.controller;

import com.javainuse.model.Category;
import com.javainuse.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin
@RequestMapping("/api/v1")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * get all categories
     * @return
     */
    @GetMapping("/categories")
    public ResponseEntity<?>getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    /**
     * get category by id
     * @param id
     * @return
     */
    @GetMapping("/categories/{id}")
    public ResponseEntity<?>getOneCategory(@PathVariable("id") Long id) {
        return ResponseEntity.ok(categoryService.getCategoryByID(id));
    }

    /**
     * create a category and returns it
     * @param category
     * @return
     */
    @PostMapping("/categories")
    public ResponseEntity<?>createCategory(@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    /**
     * update category with id
     * @param id
     * @param category
     * @return
     */
    @PutMapping("/categories/{id}")
    public ResponseEntity<?>updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        return ResponseEntity.ok(categoryService.updateCAtegory(id, category));
    }

    /**
     * delete category with id
     * @param id
     */
    @DeleteMapping("/categories/{id}")
    public void deleteCategory(@PathVariable("id") Long id) {
        categoryService.deleteCategory(id);
    }
}
