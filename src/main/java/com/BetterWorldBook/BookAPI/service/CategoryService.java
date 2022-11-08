package com.BetterWorldBook.BookAPI.service;

import com.BetterWorldBook.BookAPI.model.Books;
import com.BetterWorldBook.BookAPI.model.Category;
import com.BetterWorldBook.BookAPI.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@Service
    public class CategoryService {

        @Autowired
        CategoryRepository categoryRepository;

//    public void createCategory(Category category){
//
//        categoryRepository.save(category);
//    }

    public void addCategory(Category category){

        categoryRepository.save(category);
    }

    public ResponseEntity<Iterable<Category>> getAllCategory(){
        Iterable<Category> allCategory= categoryRepository.findAll();
        return new ResponseEntity<>(allCategory, HttpStatus.OK);
    }

    public Optional<Category> getCategoryById(Long id){

        return categoryRepository.findById(id);
    }

    public ResponseEntity<?> updateCategory(Category category, Long categoryId) {
        Category c = categoryRepository.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    public void deleteCategoryById(Long categoryid) {

        categoryRepository.deleteById(categoryid);
    }




}
