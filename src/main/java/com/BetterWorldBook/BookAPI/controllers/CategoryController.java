package com.BetterWorldBook.BookAPI.controllers;

import com.BetterWorldBook.BookAPI.model.Category;
import com.BetterWorldBook.BookAPI.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public void addCategory(@RequestBody Category category){

        categoryService.addCategory(category);
    }

    @GetMapping("/category")
    public ResponseEntity<?> getAllCategories(){

        return categoryService.getAllCategory();
    }

    @GetMapping("/category/{id}")
    public Optional<Category> getCategoryById(@PathVariable Long id){

        return categoryService.getCategoryById(id);
    }
    @PutMapping("/category/{categoryId}")
    public ResponseEntity<?> updatePoll(@RequestBody Category category, @PathVariable Long categoryId) {

        return categoryService.updateCategory(category,categoryId);
    }

    @DeleteMapping("/category/{categoryId}")
    public void deleteCategoryById(@PathVariable Long categoryId){

        categoryService.deleteCategoryById(categoryId);
    }



}
